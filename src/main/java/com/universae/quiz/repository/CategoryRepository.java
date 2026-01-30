package com.universae.quiz.repository;

import com.universae.quiz.model.Category;
import com.universae.quiz.repository.springdata.CategorySpringDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private final CategorySpringDataRepository categorySpringDataRepository;

    public CategoryRepository(CategorySpringDataRepository categorySpringDataRepository) {
        this.categorySpringDataRepository = categorySpringDataRepository;
    }

    public List<Category> getCategories(){
        return categorySpringDataRepository.findAll();
    }

    public Optional<Category> getCategory(Long id){
        return categorySpringDataRepository.findById(id);
    }
}
