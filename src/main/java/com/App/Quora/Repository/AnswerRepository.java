package com.App.Quora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.App.Quora.Entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
    Boolean existsByQuestion_IdAndUser_Id(UUID questionId, UUID userId);

    java.util.List<Answer> findByQuestion_Id(UUID questionId);

}
