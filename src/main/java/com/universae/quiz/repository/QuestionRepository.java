package com.universae.quiz.repository;

import com.universae.quiz.model.Question;
import com.universae.quiz.repository.springdata.QuestionSpringDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepository {

    private final QuestionSpringDataRepository questionSpringDataRepository;

    public QuestionRepository(QuestionSpringDataRepository questionSpringDataRepository){
        this.questionSpringDataRepository = questionSpringDataRepository;
    }

    public List<Question> getQuestions(){
        return questionSpringDataRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id){
        return questionSpringDataRepository.findById(id);
    }

    public Question save(Question question){
        return questionSpringDataRepository.save(question);
    }

    public void delete(Long id){
        questionSpringDataRepository.deleteById(id);
    }
}
