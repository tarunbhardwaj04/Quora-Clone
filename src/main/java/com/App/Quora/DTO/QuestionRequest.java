package com.App.Quora.DTO;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequest {
    @NotNull
    private String title;
    private String body;
    private String topicName;
    private UUID userId;
}
