package com.cafem.CafeMenu.dto.request.foodImage;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodImageRequest {
    private String imageUrl;

    private int foodId;
}
