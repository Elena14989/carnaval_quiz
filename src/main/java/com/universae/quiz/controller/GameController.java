package com.universae.quiz.controller;

import com.universae.quiz.model.Game;
import com.universae.quiz.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }


    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }


    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }

}