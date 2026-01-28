package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSpringDataRepository extends JpaRepository<Game, Long> {
}
