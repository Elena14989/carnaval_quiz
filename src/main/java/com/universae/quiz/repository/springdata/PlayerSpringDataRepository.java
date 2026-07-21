package com.universae.quiz.repository.springdata;

import com.universae.quiz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    boolean existsByEmail(String email);

}