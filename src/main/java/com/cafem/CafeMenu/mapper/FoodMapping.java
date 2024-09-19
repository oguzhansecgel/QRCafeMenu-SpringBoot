package com.cafem.CafeMenu.mapper;

import com.cafem.CafeMenu.dto.request.food.CreateFoodRequest;
import com.cafem.CafeMenu.dto.request.food.UpdateFoodRequest;
import com.cafem.CafeMenu.dto.response.food.GetAllFoodResponse;
import com.cafem.CafeMenu.dto.response.food.GetByIdFoodResponse;
import com.cafem.CafeMenu.dto.response.food.GetFoodWithCategoryResponse;
import com.cafem.CafeMenu.entities.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FoodMapping {

    FoodMapping INSTANCE = Mappers.getMapper(FoodMapping.class);
    @Mapping(source = "categoryId", target = "category.id")
    Food createFood(CreateFoodRequest request);

    Food updateFood(UpdateFoodRequest request,@MappingTarget Food food);
    GetByIdFoodResponse getByIdFood(Food food);

    @Mapping(source = "category.id",target = "categoryId")
    GetAllFoodResponse getAllFoodMapper(Food food);
    List<GetAllFoodResponse> foodToListFoodResponse(List<Food> food);

    @Mapping(source = "category.id", target = "categoryId")
    GetFoodWithCategoryResponse foodToGetFoodWithCategoryResponse(Food food);

    List<GetFoodWithCategoryResponse> foodToListFoodWithCategoryResponse(List<Food> food);
}
