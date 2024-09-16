package com.cafem.CafeMenu.service.abstracts;

import com.cafem.CafeMenu.dto.request.food.CreateFoodRequest;
import com.cafem.CafeMenu.dto.request.food.UpdateFoodRequest;
import com.cafem.CafeMenu.dto.response.food.*;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    List<GetAllFoodResponse> getAllFoods();
    Optional<GetByIdFoodResponse> getByIdFood(int id);
    void deletedFood(int id);
    CreateFoodResponse createFood(CreateFoodRequest request);
    UpdateFoodResponse updateFood(UpdateFoodRequest request, int id);
    List<GetFoodWithCategoryResponse> getFoodWithCategory(int id);
}
