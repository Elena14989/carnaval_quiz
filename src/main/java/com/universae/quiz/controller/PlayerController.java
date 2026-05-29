package com.universae.quiz.controller;

import com.universae.quiz.controller.request.LoginRequest;
import com.universae.quiz.controller.response.PlayerResponse;
import com.universae.quiz.model.Player;
import com.universae.quiz.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:4200")

public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player
    ) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @PostMapping("/login")
    public PlayerResponse login(@RequestBody LoginRequest request) {

        Player player = playerService.login(request.getEmail(), request.getPassword());

        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setAlias(player.getAlias());
        response.setScore(player.getScore());

        return response;
    }
}