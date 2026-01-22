package com.App.Quora.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Quora.Entity.Topic;

public interface TopicRespository extends JpaRepository<Topic, UUID> {
    
    Boolean existsByName(String name);
}
