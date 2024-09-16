package com.cafem.CafeMenu.repositories;

import com.cafem.CafeMenu.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepositories extends JpaRepository<Category, Integer> {
}
