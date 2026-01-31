package com.App.Quora.Adapters;

import com.App.Quora.DTO.CommentRequest;
import com.App.Quora.Entity.Comment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.App.Quora.Repository.UserRepository;
import com.App.Quora.Repository.AnswerRepository;
import com.App.Quora.Repository.CommentRepository;
import com.App.Quora.Entity.User;
import com.App.Quora.Entity.Answer;
import com.App.Quora.ExceptionHandler.ResourceNotFoundException;

@Component
public class CommentRequestToCommentAdapter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private CommentRepository commentRepository;

    public Comment convert(CommentRequest commentRequest) {
        if (commentRequest == null) {
            throw new IllegalArgumentException("CommentRequest cannot be null");
        }
        User user = userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Answer answer = answerRepository.findById(commentRequest.getAnswerId())
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found"));
        Comment.CommentBuilder builder = Comment.builder()
                .comment(commentRequest.getComment())
                .answer(answer)
                .createdBy(user);
        if (commentRequest.getParentId() != null) {
            Comment parent = commentRepository.findById(commentRequest.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent comment not found"));
            if (!parent.getAnswer().getId().equals(answer.getId())) {
                throw new IllegalArgumentException("Reply must belong to the same answer as the parent comment");
            }
            builder.parent(parent);
        }
        return builder.build();
    }
}
