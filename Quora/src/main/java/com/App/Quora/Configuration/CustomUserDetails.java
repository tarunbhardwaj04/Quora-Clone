package com.App.Quora.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.App.Quora.Entity.User;
import com.App.Quora.ExceptionHandler.ResourceNotFoundException;
import com.App.Quora.Repository.UserRepository;

public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    
}
