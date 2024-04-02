package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorModel, Long> {
}
