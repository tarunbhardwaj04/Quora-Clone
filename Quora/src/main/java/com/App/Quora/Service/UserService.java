package com.App.Quora.Service;

import java.util.List;
import java.util.UUID;

import com.App.Quora.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.App.Quora.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {

        if(user==null){
            throw new IllegalArgumentException("User cannot be null");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("User already exists");
        }
        if (user.getRole()==null) {
            user.setRole("USER");
            
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    

    public User getUserById(UUID id)
    {
        if (id==null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));  
    }

    public User updateUserById(UUID id, User user)
    {
        if (id==null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        User existingUser=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id: " + id));

        if(user.getUsername() != null)
        {
            existingUser.setUsername(user.getUsername());
        }   

        if(user.getEmail() != null)
        {
            existingUser.setEmail(user.getEmail());
        }   

        

        return userRepository.save(user);
    }
}
