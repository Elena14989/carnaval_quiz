package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorySpringDataRepository extends JpaRepository<Category, Long> {
}
