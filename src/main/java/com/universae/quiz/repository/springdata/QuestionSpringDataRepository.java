package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Player;
import com.universae.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSpringDataRepository extends JpaRepository<Question, Long> {
}
