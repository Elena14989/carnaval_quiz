package com.universae.quiz.controller;

import com.universae.quiz.controller.response.CategoryResponse;
import com.universae.quiz.model.Category;
import com.universae.quiz.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CategoryResponse> getCategories(){
        List<Category> categories = categoryService.getCategories();
        return categories.stream().map(category -> {
           return modelMapper.map(category, CategoryResponse.class);
        }).toList();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id ){
        return categoryService.getCategory(id);
    }

}
