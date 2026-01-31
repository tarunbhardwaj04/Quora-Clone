package com.App.Quora.DTO;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAnswerDTO {
    private UUID id;
    private String content;
}
