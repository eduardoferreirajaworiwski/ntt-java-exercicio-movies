package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardojaworiwski.academiacx.entity.DirectorModel;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorModel, Long> {

}