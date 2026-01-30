package com.universae.quiz.service;

import com.universae.quiz.repository.CategoryRepository;
import com.universae.quiz.repository.GameQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class GameQuestionService {

    private final GameQuestionRepository gameQuestionRepository;

    public GameQuestionService(GameQuestionRepository gameQuestionRepository) {
        this.gameQuestionRepository = gameQuestionRepository;
    }

}
