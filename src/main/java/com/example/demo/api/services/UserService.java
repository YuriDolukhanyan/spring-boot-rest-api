package com.example.demo.api.services;

import com.example.demo.api.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1, "A", 37, "a@email.com"));
        userList.add(new User(2, "B", 23, "b@email.com"));
        userList.add(new User(3, "C", 49, "c@email.com"));
        userList.add(new User(4, "D", 19, "d@email.com"));
        userList.add(new User(5, "E", 44, "e@email.com"));
    }

    // Get all users
    public List<User> getAllUsers() {
        return userList;
    }

    // Get user by ID with validation
    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    // Add user with check for duplicate ID
    public User addUser(User user) {
        Optional<User> existingUser = getUser(user.getId());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with ID " + user.getId() + " already exists.");
        }
        userList.add(user);
        return user;
    }

    // Update user by ID with validation
    public User updateUser(Integer id, User updatedUser) {
        User user = userList.stream()
                            .filter(u -> u.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
        
        return user;
    }

    // Delete user by ID with validation
    public String deleteUser(Integer id) {
        Optional<User> user = getUser(id);
        if (user.isPresent()) {
            userList.remove(user.get());
            return "User with ID: " + id + " deleted successfully.";
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
