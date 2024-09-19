package com.cafem.CafeMenu.mapper;

import com.cafem.CafeMenu.dto.request.category.CreateCategoryRequest;
import com.cafem.CafeMenu.dto.request.category.UpdateCategoryRequest;
import com.cafem.CafeMenu.dto.response.category.GetAllCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetByIdCategoryResponse;
import com.cafem.CafeMenu.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapping {

    CategoryMapping INSTANCE = Mappers.getMapper(CategoryMapping.class);

    Category categoryToCategory(CreateCategoryRequest request);
    Category updateCategory(UpdateCategoryRequest request, @MappingTarget Category category);
    GetByIdCategoryResponse getCategoryById(Category category);

    @Mapping(source = "id",target = "id")
    GetAllCategoryResponse getAllCategoryMapper(Category category);
    List<GetAllCategoryResponse> categoryToListCategoryResponse(List<Category> category);
}
