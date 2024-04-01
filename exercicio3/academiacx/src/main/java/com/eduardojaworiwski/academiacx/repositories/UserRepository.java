package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
