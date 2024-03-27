package com.example.academiacx.services;

import com.example.academiacx.handlers.exceptions.InvalidParameterException;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel create(UserModel userModel) {
        userModel.setId(null);
        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {
        Long id = userModel.getId();
        if (id == null || !userRepository.existsById(id)) {
            throw new InvalidParameterException("ID not found");
        }
        return userRepository.save(userModel);
    }
}
