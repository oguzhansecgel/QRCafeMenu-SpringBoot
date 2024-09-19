package com.cafem.CafeMenu.test;


import com.cafem.CafeMenu.core.exception.exceptionhandler.CategoryNotFoundException;
import com.cafem.CafeMenu.dto.request.category.CreateCategoryRequest;
import com.cafem.CafeMenu.dto.request.category.UpdateCategoryRequest;
import com.cafem.CafeMenu.dto.response.category.CreateCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetAllCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetByIdCategoryResponse;
import com.cafem.CafeMenu.entities.Category;
import com.cafem.CafeMenu.mapper.CategoryMapping;
import com.cafem.CafeMenu.repositories.CategoryRepositories;
import com.cafem.CafeMenu.service.concretes.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock// category service içerisinde kullanılan bağımlılıklar mock ile işaretleniz
    private CategoryRepositories categoryRepositories;

    @Mock
    private CategoryMapping categoryMapping;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_shouldCreateCategorySuccessfully() {
        CreateCategoryRequest createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setCategoryName("test");

        Category mockCategory = new Category();
        mockCategory.setId(1);
        mockCategory.setCategoryName("test");

        when(categoryMapping.categoryToCategory(any(CreateCategoryRequest.class))).thenReturn(mockCategory);
        when(categoryRepositories.save(any(Category.class))).thenReturn(mockCategory);

        CreateCategoryResponse result = categoryService.createCategory(createCategoryRequest);

        verify(categoryRepositories, times(1)).save(any(Category.class));
        assertEquals(1, result.getId());
        assertEquals("test", result.getCategoryName());
    }

    @Test
    void update_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest();
        updateCategoryRequest.setCategoryName("test");

        when(categoryRepositories.findById(1)).thenReturn(Optional.empty());

        CategoryNotFoundException exception = assertThrows(CategoryNotFoundException.class, () -> {
            categoryService.updateCategory(updateCategoryRequest, 1);
        });

        assertEquals("Category not found", exception.getMessage());

        verify(categoryRepositories, never()).save(any(Category.class));

    }

    @Test
    void getAllCategories_shouldReturnCategoryListSuccessfully() {
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategoryName("Category 1");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCategoryName("Category 2");

        List<Category> mockCategoryList = Arrays.asList(category1, category2);

        when(categoryRepositories.findAll()).thenReturn(mockCategoryList);

        // Act
        List<GetAllCategoryResponse> result = categoryService.getAllCategories();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Category 1", result.get(0).getCategoryName());
        assertEquals(2, result.get(1).getId());
        assertEquals("Category 2", result.get(1).getCategoryName());

        // Verify that categoryRepositories.findAll is called once
        verify(categoryRepositories, times(1)).findAll();
    }

    @Test
    void getByIdCategory_shouldReturnCategorySuccessfully() {
        // Arrange
        Category category = new Category();
        category.setId(1);
        category.setCategoryName("test");

        // Mocking categoryRepositories.findById to return a category
        when(categoryRepositories.findById(1)).thenReturn(Optional.of(category));

        // Act
        Optional<GetByIdCategoryResponse> resultOptional = categoryService.findCategoryById(1);

        // Assert
        assertTrue(resultOptional.isPresent());
        GetByIdCategoryResponse result = resultOptional.get();
        assertEquals(1, result.getId());
        assertEquals("test", result.getCategoryName());

        // Verify that findById was called once
        verify(categoryRepositories, times(1)).findById(1);
    }

    @Test
    void getByIdCategory_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        // Arrange
        when(categoryRepositories.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        CategoryNotFoundException exception = assertThrows(CategoryNotFoundException.class, () -> {
            categoryService.findCategoryById(1);
        });

        assertEquals("Category not found", exception.getMessage());

        // Verify that findById was called once
        verify(categoryRepositories, times(1)).findById(1);
    }

    @Test
    void deleteCategory_shouldDeleteCategorySuccessfully() {
        Category category = new Category();
        category.setId(1);
        category.setCategoryName("test");

        when(categoryRepositories.findById(1)).thenReturn(Optional.of(category));

        // Act
        categoryService.deleteCategory(1);

        // Assert & Verify
        verify(categoryRepositories, times(1)).findById(1);
        verify(categoryRepositories, times(1)).deleteById(1);
    }

    @Test
    void deleteCategory_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        // Arrange
        when(categoryRepositories.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        CategoryNotFoundException exception = assertThrows(CategoryNotFoundException.class, () -> {
            categoryService.deleteCategory(1);
        });

        assertEquals("Category not found", exception.getMessage());

        // Verify that delete is never called since exception is thrown
        verify(categoryRepositories, times(1)).findById(1);
        verify(categoryRepositories, never()).delete(any(Category.class));
    }
}
