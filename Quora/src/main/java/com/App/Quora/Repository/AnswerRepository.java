package com.App.Quora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.App.Quora.Entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    Boolean existsByQuestionIdAndUserId(UUID questionId, UUID userId);

}
