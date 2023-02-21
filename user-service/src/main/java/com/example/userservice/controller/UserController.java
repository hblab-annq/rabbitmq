package com.example.userservice.controller;

import com.example.userservice.model.entity.User;
import com.example.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
