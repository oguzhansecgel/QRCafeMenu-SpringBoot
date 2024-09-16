package com.cafem.CafeMenu.service.concretes;

import com.cafem.CafeMenu.dto.request.foodImage.CreateFoodImageRequest;
import com.cafem.CafeMenu.dto.response.foodImage.CreateFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetAllFoodImageResponse;
import com.cafem.CafeMenu.dto.response.foodImage.GetByFoodImageWithFood;
import com.cafem.CafeMenu.entities.Food;
import com.cafem.CafeMenu.entities.FoodImage;
import com.cafem.CafeMenu.mapper.FoodImageMapping;
import com.cafem.CafeMenu.repositories.FoodImageRepositories;
import com.cafem.CafeMenu.repositories.FoodRepositories;
import com.cafem.CafeMenu.service.abstracts.FoodImageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class FoodImageServiceImpl implements FoodImageService {

    private final FoodImageRepositories foodImageRepositories;
    private final FoodRepositories foodRepositories;

    public FoodImageServiceImpl(FoodImageRepositories foodImageRepositories, FoodRepositories foodRepositories) {
        this.foodImageRepositories = foodImageRepositories;
        this.foodRepositories = foodRepositories;
    }

    @Override
    @Transactional
    public CreateFoodImageResponse createFoodImage(CreateFoodImageRequest request) {

        MultipartFile imageFile = request.getImageFile();
        String originalFilename = imageFile.getOriginalFilename();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
        String timestamp = LocalDateTime.now().format(formatter);

        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String filename = timestamp + extension;

        try {
            String uploadDir = "uploads/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdir();
            }
            Path filePath = Paths.get(uploadDir + filename);
            Files.write(filePath, imageFile.getBytes());

            if (foodImageRepositories.existsByFoodId(request.getFoodId())) {
                throw new BaseBusinessException("An image for this food already exists.");
            }

            Food food = foodRepositories.findById(request.getFoodId())
                    .orElseThrow(() -> new BaseBusinessException("Food not found"));

            FoodImage foodImage = FoodImageMapping.INSTANCE.createFoodImage(request);
            foodImage.setImageUrl(filePath.toString());
            foodImage.setFood(food);
            FoodImage savedImage = foodImageRepositories.save(foodImage);

            return new CreateFoodImageResponse(savedImage.getImageUrl(), savedImage.getFood().getId());

        } catch (IOException e) {
            throw new BaseBusinessException("Error saving file: " + e.getMessage());
        }
    }

    @Override
    public void deletedImage(int foodImageId) {
        FoodImage foodImage = foodImageRepositories.findById(foodImageId)
                .orElseThrow(() -> new BaseBusinessException("Food image not found"));

        String filePath = foodImage.getImageUrl();
        Path path = Paths.get(filePath);

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new BaseBusinessException("Error deleting file: " + e.getMessage());
        }

        foodImageRepositories.deleteById(foodImageId);
    }

    @Override
    public GetByFoodImageWithFood getFoodImageWithFood(int foodId) {
        FoodImage foodImage = foodImageRepositories.findByFoodId(foodId);
        return FoodImageMapping.INSTANCE.foodImageToGetFoodImageWithFoodResponse(foodImage);
    }

    @Override
    public List<GetAllFoodImageResponse> getAllFoodImage() {
        List<FoodImage> foodImages = foodImageRepositories.findAll();
        return FoodImageMapping.INSTANCE.foodImageToListFoodImageResponse(foodImages);

    }
}
