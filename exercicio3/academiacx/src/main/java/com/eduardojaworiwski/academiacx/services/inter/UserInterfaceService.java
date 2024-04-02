package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserInterfaceService {
    List<UserModel> findAll();
    UserModel findById(Long id);
    UserModel create(UserModel user);
    UserModel update(UserModel user);
    boolean delete(Long id);
}
