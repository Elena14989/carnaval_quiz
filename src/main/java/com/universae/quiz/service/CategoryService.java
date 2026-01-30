package com.universae.quiz.service;

import com.universae.quiz.model.Category;
import com.universae.quiz.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.getCategories();
    }

    public Category getCategory(Long id){
        Optional<Category> optCategory  = categoryRepository.getCategory(id);

        return optCategory.orElseThrow();
    }
}
