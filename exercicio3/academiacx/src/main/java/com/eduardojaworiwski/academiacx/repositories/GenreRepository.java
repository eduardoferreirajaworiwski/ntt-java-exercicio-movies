package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.GenreModel;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {

}