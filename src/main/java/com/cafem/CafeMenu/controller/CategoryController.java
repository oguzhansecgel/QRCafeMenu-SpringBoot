package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.category.CreateCategoryRequest;
import com.cafem.CafeMenu.dto.request.category.UpdateCategoryRequest;
import com.cafem.CafeMenu.dto.response.category.CreateCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetAllCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.GetByIdCategoryResponse;
import com.cafem.CafeMenu.dto.response.category.UpdateCategoryResponse;
import com.cafem.CafeMenu.service.abstracts.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/getByIdCategory/{id}")
    public Optional<GetByIdCategoryResponse> getByIdCategory(@PathVariable int id)
    {
        return categoryService.findCategoryById(id);
    }
    @GetMapping("/getAllCategory")
    public List<GetAllCategoryResponse> getAllCategory()
    {
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/deleteCategory/{id}")
    public void deletedCategory(@PathVariable int id)
    {
        categoryService.deleteCategory(id);
    }
    @PostMapping("/createCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse createCategory(@RequestBody CreateCategoryRequest request)
    {
        return categoryService.createCategory(request);
    }
    @PutMapping("/updateCategory/{id}")
    public UpdateCategoryResponse updateCategory(@PathVariable int id, @RequestBody UpdateCategoryRequest request)
    {
        return categoryService.updateCategory(request,id);
    }
}
