package com.springboot.javaspringtwitteranalyser.controllers;

import com.springboot.javaspringtwitteranalyser.exception.ResourceNotFoundException;
import com.springboot.javaspringtwitteranalyser.model.User;
import com.springboot.javaspringtwitteranalyser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserByTwitterId(@PathVariable(value = "id") Long twitter_id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(twitter_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this twitter id :: " + twitter_id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long twitter_id,
                                               @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository
                .findById(twitter_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this twitter id :: " + twitter_id));

        user.setTwitter_id(userDetails.getTwitter_id());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long twitter_id)
            throws ResourceNotFoundException {
        User user = userRepository.findById(twitter_id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this twitter id :: " + twitter_id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
