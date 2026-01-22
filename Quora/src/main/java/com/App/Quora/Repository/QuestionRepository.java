package com.App.Quora.Repository;

import com.App.Quora.Entity.Question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    
    Page<Question> findByTitleContainingIgnoreCaseAndTopicNameContainingIgnoreCase(String questionTitle, String topicName, Pageable pageable);

    Page<Question> findByTitleContainingIgnoreCase(String questionTitle,Pageable pageable);

    Page<Question> findByTopicNameContainingIgnoreCase(String topicName,Pageable pageable); 
}
