package com.cafem.CafeMenu.mapper;

import com.cafem.CafeMenu.dto.request.foodImage.CreateFoodImageRequest;
import com.cafem.CafeMenu.dto.response.foodImage.GetAllFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetByFoodImageWithFood;
import com.cafem.CafeMenu.entities.FoodImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FoodImageMapping {

        FoodImageMapping INSTANCE = Mappers.getMapper(FoodImageMapping.class);

        @Mapping(source = "foodId",target = "food.id")
        FoodImage createFoodImage(CreateFoodImageRequest request);

        @Mapping(source = "food.id", target = "foodId")
        GetByFoodImageWithFood foodImageToGetFoodImageWithFoodResponse(FoodImage foodImage);

        @Mapping(source = "food.id",target = "foodId")
        GetAllFoodImageResponse getAllFoodImageMapper(FoodImage foodImage);
        List<GetAllFoodImageResponse> foodImageToListFoodImageResponse(List<FoodImage> FoodImage);

}
