package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel, Long> {
}
