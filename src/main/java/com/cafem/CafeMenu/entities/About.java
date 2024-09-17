package com.cafem.CafeMenu.entities;

import com.cafem.CafeMenu.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "about")
@Entity
public class About extends BaseEntity {

    private String title;
    private String content;
}
