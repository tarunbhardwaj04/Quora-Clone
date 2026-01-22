package com.App.Quora.Adapters;

import com.App.Quora.Entity.Answer;
import com.App.Quora.Entity.Question;
import com.App.Quora.Entity.User;
import com.App.Quora.ExceptionHandler.ResourceNotFoundException;
import com.App.Quora.Repository.QuestionRepository;
import com.App.Quora.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.App.Quora.Repository.AnswerRepository;
import com.App.Quora.DTO.AnswerRequest;
import com.App.Quora.DTO.UpdateAnswerDTO;

@Component
public class AnswerRequestDtoToAnswer_Adapter {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Answer convertDtoToAnswer(AnswerRequest answerRequestDto)
    {
        
        Question question = questionRepository.findById(answerRequestDto.getQuestionId())
        .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + answerRequestDto.getQuestionId()));

         User user=userRepository.findById(answerRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found with id"));

        return Answer.builder()
        .content(answerRequestDto.getContent())
        .question(question)
        .user(user)
        .build();
    }   
    public Answer updateAnswerDtoToAnswer(UpdateAnswerDTO updateAnswerDto)
    {
        Answer answer = answerRepository.findById(updateAnswerDto.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Answer not found"));

        return Answer.builder()
        .content(updateAnswerDto.getContent())
        .question(answer.getQuestion())
        .user(answer.getUser())
        .build();
    }   
}
