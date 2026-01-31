package com.App.Quora.Repository;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.App.Quora.Entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByname(String name);
    Optional<User> findByUsername(String username);

}
