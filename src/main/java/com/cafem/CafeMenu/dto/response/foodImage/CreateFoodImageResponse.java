package com.cafem.CafeMenu.dto.response.foodImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodImageResponse {
    private String imageUrl;

    private int foodId;
}
