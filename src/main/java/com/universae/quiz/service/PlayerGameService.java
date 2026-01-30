package com.universae.quiz.service;

import com.universae.quiz.repository.PlayerGameRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameService {

    private final PlayerGameRepository playerGameRepository;

    public PlayerGameService(PlayerGameRepository playerGameRepository) {
        this.playerGameRepository = playerGameRepository;

    }
}
