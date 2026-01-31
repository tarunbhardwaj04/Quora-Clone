package com.App.Quora.Adapters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.App.Quora.DTO.QuestionRequest;
import com.App.Quora.Entity.Question;
import com.App.Quora.Entity.Topic;
import com.App.Quora.Entity.User;
import com.App.Quora.ExceptionHandler.ResourceNotFoundException;
import com.App.Quora.Repository.TopicRepository;
import com.App.Quora.Repository.UserRepository;

@Component
public class QuestionDtoToQuestionAdaptor {
        @Autowired
        private TopicRepository topicRespository;

        @Autowired
        private UserRepository userRepository;

        @Transactional
        public Question convertToQuestion(QuestionRequest questionRequest, String username) {
                String topicName = questionRequest.getTopicName() != null ? questionRequest.getTopicName() : "General";

                System.out.println("topicName: " + topicName);
                Topic topic = null;
                if (questionRequest.getTopicName() != null) {
                        topic = topicRespository.findByName(questionRequest.getTopicName()).orElse(null);
                }

                if (topic == null) {
                        topic = topicRespository.findByName(topicName)
                                        .orElseGet(() -> topicRespository
                                                        .save(Topic.builder().name(topicName).build()));
                }

                User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                 "User not found with id: " + username));

                Question question = Question.builder()
                                .title(questionRequest.getTitle())
                                .body(questionRequest.getBody())
                                .topic(topic)
                                .user(user)
                                .build();
                return question;

        }

}
