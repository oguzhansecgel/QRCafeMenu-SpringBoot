package com.cafem.CafeMenu.dto.request.food;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodRequest {


    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int categoryId;

}
