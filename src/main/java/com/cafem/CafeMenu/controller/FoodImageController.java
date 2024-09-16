package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.foodImage.CreateFoodImageRequest;
import com.cafem.CafeMenu.dto.response.foodImage.CreateFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetAllFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetByFoodImageWithFood;
import com.cafem.CafeMenu.service.abstracts.FoodImageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/foodImage")
public class FoodImageController {


    private final FoodImageService foodImageService;

    public FoodImageController(FoodImageService foodImageService) {
        this.foodImageService = foodImageService;
    }

    @GetMapping("/foodImageWithFood/{foodId}")
    public GetByFoodImageWithFood getByFoodImageWithFood(@PathVariable int foodId)
    {
        return foodImageService.getFoodImageWithFood(foodId);
    }
    @GetMapping("/getAllFoodImage")
    public List<GetAllFoodImageResponse> getAllFoodImage()
    {
        return foodImageService.getAllFoodImage();
    }
    @DeleteMapping("deletedFoodImage/{id}")
    public void deletedFoodImage(@PathVariable int id) {
        foodImageService.deletedImage(id);
    }

    @ApiOperation(value = "Food Image Upload", notes = "Upload an image for food.")
    @PostMapping(value = "/createFoodImage", consumes = "multipart/form-data")
    public CreateFoodImageResponse createFoodImageResponse(
            @ApiParam(value = "Image file", required = true) @RequestParam("imageFile") MultipartFile imageFile,
            @ApiParam(value = "Food ID", required = true) @RequestParam("foodId") int foodId) {

        CreateFoodImageRequest createFoodImageRequest = new CreateFoodImageRequest();
        createFoodImageRequest.setFoodId(foodId);
        createFoodImageRequest.setImageFile(imageFile);
        return foodImageService.createFoodImage(createFoodImageRequest);
    }


}
