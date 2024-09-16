package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.food.CreateFoodRequest;
import com.cafem.CafeMenu.dto.response.food.CreateFoodResponse;
import com.cafem.CafeMenu.dto.response.food.GetAllFoodResponse;
import com.cafem.CafeMenu.dto.response.food.GetFoodWithCategoryResponse;
import com.cafem.CafeMenu.service.abstracts.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @GetMapping("/getAllFood")
    public List<GetAllFoodResponse> getAllFood()
    {
        return foodService.getAllFoods();
    }
    @GetMapping("/foodWithCategory/{categoryId}")
    public List<GetFoodWithCategoryResponse> getFoodWithCategoryResponses(@PathVariable int categoryId)
    {
        return foodService.getFoodWithCategory(categoryId);
    }
    @PostMapping("/createFood")
    public CreateFoodResponse createFood(@RequestBody CreateFoodRequest request)
    {
        return foodService.createFood(request);
    }
}
