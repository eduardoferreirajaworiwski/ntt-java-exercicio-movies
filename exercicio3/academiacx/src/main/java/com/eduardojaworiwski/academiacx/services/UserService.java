package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.UserModel;
import com.eduardojaworiwski.academiacx.repository.UserRepository;
import com.eduardojaworiwski.academiacx.services.inter.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterfaceService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> list() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel create(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel update(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
