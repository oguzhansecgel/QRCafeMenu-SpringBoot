package com.cafem.CafeMenu.entities;

import com.cafem.CafeMenu.core.entity.BaseEntity;
import jakarta.persistence.Column;
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
@Table(name = "contact")
@Entity
public class Contact extends BaseEntity {

    private String title;
    private String description;
    @Column(name = "facebook_url",nullable = true)
    private String facebook;
    @Column(name = "instagram_url",nullable = true)
    private String instagram;
}
