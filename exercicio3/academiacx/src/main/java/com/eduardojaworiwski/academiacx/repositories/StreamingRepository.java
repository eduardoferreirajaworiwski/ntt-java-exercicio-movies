package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {

}
