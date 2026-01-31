package com.App.Quora.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Quora.Entity.Like;
import com.App.Quora.Entity.LikeTypeEnum;
import com.App.Quora.Entity.User;

public interface LikeRepository extends JpaRepository<Like, UUID> {

    Optional<Like> findByTargetIdAndContentTypeAndLikingUser(UUID targetId, LikeTypeEnum contentType, User likingUser);

    long countByTargetIdAndContentType(UUID targetId, LikeTypeEnum contentType);
}
