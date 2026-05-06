package com.universae.quiz.controller;

import com.universae.quiz.controller.request.AnswerRequest;
import com.universae.quiz.controller.response.AnswerResponse;
import com.universae.quiz.controller.response.QuestionResponse;
import com.universae.quiz.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/games/{gameId}/next")
    public QuestionResponse getNextQuestion(
            @PathVariable Long gameId,
            @RequestParam Long categoryId) {

        return questionService.getNextQuestion(gameId, categoryId);
    }

    @PostMapping("/games/{gameId}/answer")
    public AnswerResponse checkAnswer(
            @PathVariable Long gameId,
            @RequestBody AnswerRequest request) {

        return questionService.checkAnswer(gameId, request);
    }
}
