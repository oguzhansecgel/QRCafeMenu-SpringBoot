package com.cafem.CafeMenu.service.concretes;

import com.cafem.CafeMenu.dto.request.food.CreateFoodRequest;
import com.cafem.CafeMenu.dto.request.food.UpdateFoodRequest;
import com.cafem.CafeMenu.dto.response.food.*;
import com.cafem.CafeMenu.entities.Food;
import com.cafem.CafeMenu.mapper.CategoryMapping;
import com.cafem.CafeMenu.mapper.FoodMapping;
import com.cafem.CafeMenu.repositories.FoodRepositories;
import com.cafem.CafeMenu.service.abstracts.FoodService;
import org.springframework.stereotype.Service;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepositories foodRepositories;

    public FoodServiceImpl(FoodRepositories foodRepositories) {
        this.foodRepositories = foodRepositories;
    }

    @Override
    public List<GetAllFoodResponse> getAllFoods() {
        List<Food> food = foodRepositories.findAll();
        return FoodMapping.INSTANCE.foodToListFoodResponse(food);
    }

    @Override
    public Optional<GetByIdFoodResponse> getByIdFood(int id) {
        Optional<Food> food = foodRepositories.findById(id);
        if (food.isEmpty())
        {
            throw new BaseBusinessException("Not found");
        }

        return food.map(FoodMapping.INSTANCE::getByIdFood);
    }

    @Override
    public void deletedFood(int id) {
        Optional<Food> existingFood = foodRepositories.findById(id);
        if (existingFood.isEmpty())
        {
            throw new RuntimeException("Food not found");
        }
        foodRepositories.deleteById(id);
    }

    @Override
    public CreateFoodResponse createFood(CreateFoodRequest request) {

        Food food = FoodMapping.INSTANCE.createFood(request);
        Food savedFood = foodRepositories.save(food);
        return new CreateFoodResponse(
                savedFood.getId(),
                savedFood.getFoodName(),
                savedFood.getFoodDescription(),
                savedFood.getFoodPrice(),
                savedFood.getCategory().getId()
        );
    }

    @Override
    public UpdateFoodResponse updateFood(UpdateFoodRequest request, int id) {
        Optional<Food> optionalFood = foodRepositories.findById(id);
        if (optionalFood.isEmpty())
        {
            throw new BaseBusinessException("Food not found");
        }
        Food existingFood = optionalFood.get();
        Food food = FoodMapping.INSTANCE.updateFood(request, existingFood);
        Food savedFood = foodRepositories.save(food);
        return new UpdateFoodResponse( savedFood.getId(),
                savedFood.getFoodName(),
                savedFood.getFoodDescription(),
                savedFood.getFoodPrice(),
                savedFood.getCategory().getId());
    }

    @Override
    public List<GetFoodWithCategoryResponse> getFoodWithCategory(int id) {
        List<Food> foods = foodRepositories.findAllByCategoryId(id);
        return FoodMapping.INSTANCE.foodToListFoodWithCategoryResponse(foods);
    }
}
