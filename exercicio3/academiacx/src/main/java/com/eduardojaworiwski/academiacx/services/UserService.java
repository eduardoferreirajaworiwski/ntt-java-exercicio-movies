package com.eduardojaworiwski.academiacx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.eduardojaworiwski.academiacx.repositories.UserRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.eduardojaworiwski.academiacx.entity.UserModel;

public class UserService {
    

    @Autowired
    UserRepository userRepository;

    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser(@NotNull @Valid Long id) {
        if (id == null) {
            return null;
        }
        Optional<UserModel> optionalUserModel = userRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            return null;
        }

        return optionalUserModel.get();

    }


    public UserModel registerUser(UserModel userModel) {
        if(userModel.getId() != null) {
            return null;
        }
        return userRepository.save(userModel);
    }

    public UserModel updateUser(UserModel userModel) {
        if (userModel.getId() == null) {
            return null;
        }
        UserModel user = userRepository.findById(userModel.getId()).get();
        user.setName(userModel.getName());
        UserModel updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public String deleteUser(@NotNull @Valid Long id) {
        UserModel deletedUser = getUser(id);
            if (deletedUser == null) {
                return "Error by id" + id;
            }
            userRepository.deleteById(id);
            return "Deleted";
    }


}
