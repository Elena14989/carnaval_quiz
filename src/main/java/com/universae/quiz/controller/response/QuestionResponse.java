package com.universae.quiz.controller.response;

import lombok.Data;

@Data
    public class QuestionResponse {

    private Long id;

    private String statement;

    private String optionA;

    private String optionB;

    private String optionC;

    private String categoryName;

    }
