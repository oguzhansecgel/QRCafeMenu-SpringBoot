package com.cafem.CafeMenu.entities;

import com.cafem.CafeMenu.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_images")
@Entity
public class FoodImage extends BaseEntity {

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;
}
