package com.App.Quora.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.Quora.Entity.Comment;
import com.App.Quora.ExceptionHandler.ResourceNotFoundException;
import com.App.Quora.Repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        if (comment == null) {
            throw new ResourceNotFoundException("Comment cannot be null");
        }
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByAnswerId(UUID answerId) {
        return commentRepository.findByAnswer_Id(answerId);
    }

    public List<Comment> getCommentsByParentId(UUID parentId) {
        return commentRepository.findByParent_Id(parentId);
    }
}
