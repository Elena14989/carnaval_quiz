package com.universae.quiz.controller.response;

import lombok.Data;

@Data
public class AnswerResponse {

    private boolean correct;
    private String correctAnswer;
    private String message;
}