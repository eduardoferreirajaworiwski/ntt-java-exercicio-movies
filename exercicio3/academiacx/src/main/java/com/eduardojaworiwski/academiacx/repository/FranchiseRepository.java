package com.eduardojaworiwski.academiacx.repository;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long> {
}
