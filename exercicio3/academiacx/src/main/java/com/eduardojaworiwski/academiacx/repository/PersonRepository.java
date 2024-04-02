package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
