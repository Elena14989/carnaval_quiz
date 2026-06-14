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

    // 1. Crear partida básica
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    // 2. Obtener partida por id
    public Game getGame(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game no encontrado con id: " + id));
    }

    // 3. Eliminar partida
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

}