package com.App.Quora.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.App.Quora.Adapters.AnswerDtoTOAnswerAdapter;
import com.App.Quora.DTO.AnswerRequest;
import com.App.Quora.Entity.Answer;
import com.App.Quora.Service.AnswerService;
import com.App.Quora.DTO.UpdateAnswerDTO;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerDtoTOAnswerAdapter answerAdapter;

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody AnswerRequest request) {

        Answer comingAnswer = answerAdapter.convertDtoToAnswer(request);

        return ResponseEntity.ok(answerService.createAnswer(comingAnswer));
    }

    @PutMapping
    public ResponseEntity<Answer> updateAnswer(@RequestBody UpdateAnswerDTO request) {
        Answer comingAnswer = answerAdapter.updateAnswerDtoToAnswer(request);
        return ResponseEntity.ok(answerService.updateAnswer(comingAnswer));
    }

    @GetMapping
    public ResponseEntity<Page<?>> getAllAnswers() {
        return ResponseEntity.ok(answerService.getAllAnswers());
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<java.util.List<Answer>> getAnswersByQuestionId(
            @org.springframework.web.bind.annotation.PathVariable java.util.UUID questionId) {
        return ResponseEntity.ok(answerService.getAnswersByQuestionId(questionId));
    }
}
