package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Player;
import com.universae.quiz.model.PlayerGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerGameSpringDataRepository extends JpaRepository<PlayerGame, Long> {
}
