package com.universae.quiz.service;

import com.universae.quiz.controller.request.AnswerRequest;
import com.universae.quiz.controller.response.AnswerResponse;
import com.universae.quiz.controller.response.QuestionResponse;
import com.universae.quiz.model.Question;
import com.universae.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public QuestionService(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestions(){
        return questionRepository.getQuestions();
    }

    public Optional<Question> getQuestionById(Long id){
        return questionRepository.getQuestionById(id);
    }

    public void delete(Long id){
        questionRepository.delete(id);
    }

    public QuestionResponse getNextQuestion(Long gameId, Long categoryId) {

        List<Question> questions = questionRepository.getQuestions()
                .stream()
                .filter(q -> q.getCategory().getId().equals(categoryId))
                .toList();

        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found");
        }

        int random = (int)(Math.random() * questions.size());

        Question question = questions.get(random);

        return mapToResponse(question);

    }
    private QuestionResponse mapToResponse(Question question) {
        QuestionResponse response = modelMapper.map(question, QuestionResponse.class);
        response.setCategoryName(question.getCategory().getName());
        return response;

    }
    public AnswerResponse checkAnswer(Long gameId, AnswerRequest request) {

        Question question = questionRepository.getQuestionById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean isCorrect = question.getCorrectAnswer()
                .equalsIgnoreCase(request.getSelectedOption());

        AnswerResponse response = new AnswerResponse();
        response.setCorrect(isCorrect);
        response.setCorrectAnswer(question.getCorrectAnswer());

        if (isCorrect) {
            response.setMessage("¡Correcto!");
        } else {
            response.setMessage("Incorrecto");
        }

        return response;
    }
}

