package com.cafem.CafeMenu.dto.response.category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResponse {
    private int id;
    private String categoryName;
}
