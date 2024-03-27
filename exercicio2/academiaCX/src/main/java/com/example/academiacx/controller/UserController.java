package com.example.academiacx.controller;

import com.example.academiacx.models.UserModel;
import com.example.academiacx.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> findAll() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserModel save(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }

    @PutMapping("/{id}")
    public UserModel update(@PathVariable Long id, @RequestBody UserModel userModel) {
        userModel.setId(id); // Set the ID from the path variable
        return userService.update(userModel);
    }
}
