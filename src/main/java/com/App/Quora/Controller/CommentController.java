package com.App.Quora.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.App.Quora.Entity.Comment;
import com.App.Quora.Service.CommentService;
import com.App.Quora.DTO.CommentRequest;
import com.App.Quora.Adapters.CommentRequestToCommentAdapter;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRequestToCommentAdapter CommentAdapter;

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CommentAdapter.convert(commentRequest));
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable UUID answerId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentsByAnswerId(answerId));
    }

}
