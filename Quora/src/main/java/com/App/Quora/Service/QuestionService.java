package com.App.Quora.Service;

import com.App.Quora.Entity.Question;
import com.App.Quora.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Page<Question> getAllQuestions()
    {

        Pageable pageable = PageRequest.of(0, 10,Sort.by("createdAt").descending());
        return questionRepository.findAll(pageable);
    }

    public ResponseEntity<Question> getQuestionById(@PathVariable UUID uuid)
    {
        if (uuid==null)
        {
            throw new IllegalArgumentException("UUID cannot be null");
        }
        return questionRepository.findById(uuid)
            .map(question -> ResponseEntity.ok(question)) 
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public Question saveQuestion(Question question)
    {
        if (question==null)
        {
            throw new IllegalArgumentException("Question must have a value");
        }
        return questionRepository.save(question);
    }

    public Page<?> search(String questionTitle,String topicName)
    {
        Pageable pageable = PageRequest.of(0, 10,Sort.by("createdAt").descending());

        if(questionTitle!=null && topicName!=null)
        {
            questionRepository.findByTitleContainingIgnoreCaseAndTopicNameContainingIgnoreCase(questionTitle, topicName, pageable);
        }
        else if (questionTitle!=null)
        {
            questionRepository.findByTitleContainingIgnoreCase(questionTitle,pageable);
        }
        else if (topicName!=null)
        {
            questionRepository.findByTopicNameContainingIgnoreCase(topicName,pageable);
        }

        return questionRepository.findAll(pageable);
    }
}
