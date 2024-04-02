package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.StudioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<StudioModel, Long> {
}
