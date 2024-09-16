package com.cafem.CafeMenu.entities;

import com.cafem.CafeMenu.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class Category extends BaseEntity {

    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> foods;
}
