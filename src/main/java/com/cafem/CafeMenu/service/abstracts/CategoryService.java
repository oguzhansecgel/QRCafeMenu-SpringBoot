package com.cafem.CafeMenu.service.abstracts;

import com.cafem.CafeMenu.dto.request.category.CreateCategoryRequest;
import com.cafem.CafeMenu.dto.request.category.UpdateCategoryRequest;
import com.cafem.CafeMenu.dto.response.category.CreateCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetAllCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetByIdCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.UpdateCategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CreateCategoryResponse createCategory(CreateCategoryRequest request);
    UpdateCategoryResponse updateCategory(UpdateCategoryRequest request, int id);
    List<GetAllCategoryResponse> getAllCategories();
    Optional<GetByIdCategoryResponse> findCategoryById(int id);
    void deleteCategory(int id);
}
