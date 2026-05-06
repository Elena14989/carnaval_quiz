package com.universae.quiz.controller.request;

import lombok.Data;

@Data
public class AnswerRequest {

    private Long questionId;
    private String selectedOption;

}