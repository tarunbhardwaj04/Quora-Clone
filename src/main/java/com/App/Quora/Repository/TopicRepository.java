package com.App.Quora.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Quora.Entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

    Boolean existsByName(String name);

    Optional<Topic> findByName(String name);

    Optional<Topic> findByIdOrNameContainingIgnoreCase(UUID id, String topicName);

    Page<Topic> findByNameContainingIgnoreCase(String topicName, Pageable pageable);
}
