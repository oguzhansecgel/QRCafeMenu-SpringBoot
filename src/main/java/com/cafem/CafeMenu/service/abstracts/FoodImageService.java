package com.cafem.CafeMenu.service.abstracts;

import com.cafem.CafeMenu.dto.request.foodImage.CreateFoodImageRequest;
import com.cafem.CafeMenu.dto.response.foodImage.CreateFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetAllFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetByFoodImageWithFood;
import com.cafem.CafeMenu.entities.FoodImage;

import java.util.List;

public interface FoodImageService {

    CreateFoodImageResponse createFoodImage(CreateFoodImageRequest request);
    void deletedImage(int foodImageId);
    GetByFoodImageWithFood getFoodImageWithFood(int foodId);
    List<GetAllFoodImageResponse> getAllFoodImage();
}
