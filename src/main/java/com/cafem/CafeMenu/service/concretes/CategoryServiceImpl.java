package com.cafem.CafeMenu.service.concretes;

import com.cafem.CafeMenu.dto.request.category.CreateCategoryRequest;
import com.cafem.CafeMenu.dto.request.category.UpdateCategoryRequest;
import com.cafem.CafeMenu.dto.response.category.CreateCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetAllCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetByIdCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.UpdateCategoryResponse;
import com.cafem.CafeMenu.entities.Category;
import com.cafem.CafeMenu.mapper.CategoryMapping;
import com.cafem.CafeMenu.repositories.CategoryRepositories;
import com.cafem.CafeMenu.service.abstracts.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepositories categoryRepositories;

    public CategoryServiceImpl(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {
        Category category = CategoryMapping.INSTANCE.CategoryToCategory(request);
        Category savedCategory = categoryRepositories.save(category);
        return new CreateCategoryResponse(
                savedCategory.getId(),
                savedCategory.getCategoryName()
        );
    }

    @Override
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request, int id) {
        Optional<Category> optionalCategory = categoryRepositories.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        Category existingCategory = optionalCategory.get();

        Category category = CategoryMapping.INSTANCE.UpdateCategory(request,existingCategory);
        Category savedCategory = categoryRepositories.save(category);
        return new UpdateCategoryResponse(
                savedCategory.getId(),
                savedCategory.getCategoryName()
        );
    }

    @Override
    public List<GetAllCategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepositories.findAll();
        return CategoryMapping.INSTANCE.categoryToListCategoryResponse(categories);
    }

    @Override
    public Optional<GetByIdCategoryResponse> findCategoryById(int id) {
        Optional<Category> category = categoryRepositories.findById(id);
        if (category.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        return category.map(CategoryMapping.INSTANCE::getCategoryById);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepositories.deleteById(id);
    }
}
