package com.universae.quiz.service;

import com.universae.quiz.model.Game;
import com.universae.quiz.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game no encontrado con id: " + id));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

}