package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Category;
import com.universae.quiz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Long> {
}
