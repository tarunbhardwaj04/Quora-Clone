package com.App.Quora.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.Quora.DTO.LikeRequest;
import com.App.Quora.Entity.Like;
import com.App.Quora.Entity.User;
import com.App.Quora.Repository.AnswerRepository;
import com.App.Quora.Repository.CommentRepository;
import com.App.Quora.Repository.LikeRepository;
import com.App.Quora.Repository.QuestionRepository;
import com.App.Quora.Repository.UserRepository;

@Service
public class LikeService {
    @Autowired private LikeRepository likeRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private QuestionRepository questionRepository;
    @Autowired private AnswerRepository answerRepository;
    @Autowired private CommentRepository commentRepository;

    @Transactional // Always use Transactional for Save/Delete operations
    public String doLike(LikeRequest likeRequest) {
        // 1. Fetch the Liking User
        User likingUser = userRepository.findById(likeRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Check for existing toggle
        Optional<Like> existingLike = likeRepository.findByTargetIdAndContentTypeAndLikingUser(
                likeRequest.getTargetId(), likeRequest.getContentType(), likingUser);

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            long newCount = likeRepository.countByTargetIdAndContentType(
                    likeRequest.getTargetId(), likeRequest.getContentType());
            return "Vote removed. Current count: " + newCount;
        }
        Like.LikeBuilder likeBuilder = Like.builder()
                .targetId(likeRequest.getTargetId())
                .contentType(likeRequest.getContentType())
                .likingUser(likingUser);

        // 4. Validate target existence AND set the specific reference
        switch (likeRequest.getContentType()) {
            case QUESTION -> likeBuilder.question(questionRepository.findById(likeRequest.getTargetId())
                    .orElseThrow(() -> new RuntimeException("Question not found")));
            
            case ANSWER -> likeBuilder.answer(answerRepository.findById(likeRequest.getTargetId())
                    .orElseThrow(() -> new RuntimeException("Answer not found")));
            
            case COMMENT -> likeBuilder.comment(commentRepository.findById(likeRequest.getTargetId())
                    .orElseThrow(() -> new RuntimeException("Comment not found")));
            
            case USER -> likeBuilder.likedUser(userRepository.findById(likeRequest.getTargetId())
                    .orElseThrow(() -> new RuntimeException("Target User not found")));
        };

        // 5. Build, Save, and Return
        likeRepository.save(likeBuilder.build());
        
        long newCount = likeRepository.countByTargetIdAndContentType(
                likeRequest.getTargetId(), likeRequest.getContentType());
        return "Vote added. Current count: " + newCount;
    }
}