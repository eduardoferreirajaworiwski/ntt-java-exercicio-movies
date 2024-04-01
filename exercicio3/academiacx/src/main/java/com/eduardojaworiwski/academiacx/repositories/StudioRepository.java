package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.StudioModel;

@Repository
public interface StudioRepository extends JpaRepository<StudioModel, Long> {

}
