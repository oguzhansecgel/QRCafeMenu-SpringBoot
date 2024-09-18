package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.food.CreateFoodRequest;
import com.cafem.CafeMenu.dto.request.food.UpdateFoodRequest;
import com.cafem.CafeMenu.dto.response.food.*;
import com.cafem.CafeMenu.service.abstracts.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getByIdFood/{id}")
    public Optional<GetByIdFoodResponse> getByIdFoodResponse(@PathVariable int id )
    {
        return foodService.getByIdFood(id);
    }
    @GetMapping("/foodWithCategory/{categoryId}")
    public List<GetFoodWithCategoryResponse> getFoodWithCategoryResponses(@PathVariable int categoryId)
    {
        return foodService.getFoodWithCategory(categoryId);
    }
    @DeleteMapping("/deleteFood/{id}")
    public void deleteFood(@PathVariable int id)
    {
        foodService.deletedFood(id);
    }
    @PostMapping("/createFood")
    public CreateFoodResponse createFood(@RequestBody CreateFoodRequest request)
    {
        return foodService.createFood(request);
    }
    @PutMapping("/updateFood/{id}")
    public UpdateFoodResponse updateFood(@PathVariable int id, @RequestBody UpdateFoodRequest request)
    {
        return foodService.updateFood(request,id);
    }
}
