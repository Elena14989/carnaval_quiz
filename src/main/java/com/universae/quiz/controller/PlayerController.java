package com.universae.quiz.controller;

import com.universae.quiz.model.Player;
import com.universae.quiz.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
    // 🔹 READ ONE → obtener jugador por id
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    // 🔹 CREATE → crear jugador
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // 🔹 UPDATE → actualizar jugador
    @PutMapping("/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player
    ) {
        return playerService.updatePlayer(id, player);
    }

    // 🔹 DELETE → borrar jugador (si se permite)
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}