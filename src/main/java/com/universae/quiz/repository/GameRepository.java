package com.universae.quiz.repository;

import com.universae.quiz.model.Game;
import com.universae.quiz.repository.springdata.GameSpringDataRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GameRepository {

    private final GameSpringDataRepository gameSpringDataRepository;

    public GameRepository(GameSpringDataRepository gameSpringDataRepository) {
        this.gameSpringDataRepository = gameSpringDataRepository;
    }

    public Game save(Game game) {
        return gameSpringDataRepository.save(game);
    }

    public Optional<Game> findById(Long id) {
        return gameSpringDataRepository.findById(id);
    }

    public void deleteById(Long id) {
        gameSpringDataRepository.deleteById(id);
    }
}