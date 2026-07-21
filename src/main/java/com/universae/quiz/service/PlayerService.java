package com.universae.quiz.service;

import com.universae.quiz.model.Player;
import com.universae.quiz.repository.PlayerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;


    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Player createPlayer(Player player) {

        if (playerRepository.existsByEmail(player.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El email ya está registrado"
            );
        }
        player.setScore(0);
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        return playerRepository.save(player);

    }

    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player no encontrado con id: " + id));
    }

    public Player updatePlayer(Long id, Player playerData) {
        Player player = getPlayer(id);
        player.setName(playerData.getName());
        player.setAlias(playerData.getAlias());
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player findByEmail(String email) {
        return playerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Player no encontrado con email: " + email));
    }

}