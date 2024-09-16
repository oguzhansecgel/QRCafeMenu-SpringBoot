package com.cafem.CafeMenu.dto.request.foodImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodImageRequest {
    private MultipartFile imageFile;

    private int foodId;
}
