package com.App.Quora.DTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {

    @NotNull
    private String content;
    private UUID userId; 
    private UUID questionId;
}