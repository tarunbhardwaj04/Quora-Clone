package com.App.Quora.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Quora.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findByParent_Id(UUID parentId);

    List<Comment> findByAnswer_Id(UUID answerId);

}
