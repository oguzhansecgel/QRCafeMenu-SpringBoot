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
@Table(name = "foods")
@Entity
public class Food extends BaseEntity {

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_description")
    private String foodDescription;

    @Column(name = "food_price")
    private double foodPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "food", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FoodImage foodImage;
}
