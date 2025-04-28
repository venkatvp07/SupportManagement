package com.repo.supportmanagement.controller;

import com.repo.supportmanagement.model.User;
import com.repo.supportmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        Optional<User> userOpt =userRepo.getByUserId(userId);
        return userOpt.get();
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        User savedUser = userRepo.save(user);
        return "User is added : " + savedUser.toString();
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        User updatingUser = userRepo.getById(user.getUserId());
        updatingUser.setName(user.getName());
        updatingUser.setEmailId(user.getEmailId());
        updatingUser.setUserType(user.getUserType());
        userRepo.save(updatingUser);
        return "User is updated : " + user.toString();
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userRepo.deleteById(userId);
        return "User is deleted successfully";
    }

    @DeleteMapping
    public String deleteAllUsers() {
        userRepo.deleteAll();
        return "All User is deleted.";
    }

}
