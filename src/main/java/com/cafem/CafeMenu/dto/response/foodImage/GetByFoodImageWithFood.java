package com.cafem.CafeMenu.dto.response.foodImage;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByFoodImageWithFood {
    private String imageUrl;

    private int foodId;
}
