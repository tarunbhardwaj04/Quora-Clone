package com.App.Quora.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.App.Quora.Entity.Answer;
import com.App.Quora.Repository.AnswerRepository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import com.App.Quora.ExceptionHandler.BadRequestException;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public Answer createAnswer(Answer answer) throws BadRequestException {

        if (answerRepository.existsByQuestion_IdAndUser_Id(answer.getQuestion().getId(),
                answer.getUser().getId())) {
            throw new BadRequestException(
                    "You have already answered this question. Please update your existing answer.");
        }
        return answerRepository.save(answer);

    }

    public Answer updateAnswer(Answer answer) {
        if (answer == null) {
            throw new BadRequestException("Answer is null");
        }
        return answerRepository.save(answer);
    }

    public Page<?> getAllAnswers() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        return answerRepository.findAll(pageable);
    }

    public List<Answer> getAnswersByQuestionId(UUID questionId) {
        return answerRepository.findByQuestion_Id(questionId);
    }

}
