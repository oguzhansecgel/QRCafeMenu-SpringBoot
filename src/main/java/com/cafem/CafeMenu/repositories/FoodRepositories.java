package com.cafem.CafeMenu.repositories;

import com.cafem.CafeMenu.dto.response.food.GetFoodWithCategoryResponse;
import com.cafem.CafeMenu.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepositories extends JpaRepository<Food, Integer> {
    List<Food> findAllByCategoryId(int categoryId);
}
