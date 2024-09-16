package com.cafem.CafeMenu.dto.request.food;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int categoryId;

}
