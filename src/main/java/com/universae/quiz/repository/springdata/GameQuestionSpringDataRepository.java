package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Game;
import com.universae.quiz.model.GameQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameQuestionSpringDataRepository extends JpaRepository<GameQuestion, Long> {
}
