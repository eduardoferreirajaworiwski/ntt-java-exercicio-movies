package com.eduardojaworiwski.academiacx.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseModel, Long> {

}