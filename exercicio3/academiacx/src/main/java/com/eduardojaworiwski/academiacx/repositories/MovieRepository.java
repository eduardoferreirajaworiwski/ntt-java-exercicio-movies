package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {

}
