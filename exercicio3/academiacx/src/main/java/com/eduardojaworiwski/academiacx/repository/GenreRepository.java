package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {
}
