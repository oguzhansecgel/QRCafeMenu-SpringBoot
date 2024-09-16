package com.cafem.CafeMenu.dto.response.food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodResponse {
    private int id;

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int categoryId;
}
