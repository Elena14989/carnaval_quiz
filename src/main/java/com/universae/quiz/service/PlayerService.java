package com.universae.quiz.service;

import com.universae.quiz.model.Player;
import com.universae.quiz.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }

    // 🔹 CREATE → guardar jugador en BD
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // 🔹 READ ONE → obtener jugador por id
    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player no encontrado con id: " + id));
    }

    // 🔹 UPDATE → actualizar jugador
    public Player updatePlayer(Long id, Player playerData) {
        Player player = getPlayer(id);
        player.setName(playerData.getName());
        player.setAlias(playerData.getAlias());
        return playerRepository.save(player);
    }

    // 🔹 DELETE → borrar jugador
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

}
