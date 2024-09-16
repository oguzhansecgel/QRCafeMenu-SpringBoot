package com.cafem.CafeMenu.repositories;

import com.cafem.CafeMenu.dto.response.foodImage.CreateFoodImageResponse;
import com.cafem.CafeMenu.entities.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodImageRepositories extends JpaRepository<FoodImage, Integer> {

    boolean existsByFoodId(int foodId);
    FoodImage findByFoodId(int foodId);
}
