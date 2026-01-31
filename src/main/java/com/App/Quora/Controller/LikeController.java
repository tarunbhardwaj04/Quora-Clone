package com.App.Quora.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.Quora.DTO.LikeRequest;

import com.App.Quora.Service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<String> like(@RequestBody LikeRequest likeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.doLike(likeRequest));
    }
}
