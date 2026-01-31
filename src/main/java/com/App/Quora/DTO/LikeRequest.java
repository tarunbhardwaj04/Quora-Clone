package com.App.Quora.DTO;

import java.util.UUID;

import com.App.Quora.Entity.LikeTypeEnum;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LikeRequest {
    private UUID targetId;
    private LikeTypeEnum contentType;
    private UUID userId;
}
