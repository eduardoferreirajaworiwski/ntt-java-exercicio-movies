package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserInterfaceController {

    @GetMapping
    ResponseEntity<List<UserModel>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserModel> getUserById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<UserModel> createUser(@RequestBody UserModel user);

    @PutMapping("/{id}")
    ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel updatedUser);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
