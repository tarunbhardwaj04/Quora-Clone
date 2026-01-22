package com.App.Quora.Controller;

import com.App.Quora.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.App.Quora.Entity.Question;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<Page<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.saveQuestion(question));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<?>> searchQuestion(@RequestParam (required = false)String questionTitle,@RequestParam (required = false) String topicName)
    {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.search(questionTitle,topicName));
    }

}
