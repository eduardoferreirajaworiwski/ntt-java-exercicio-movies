package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
