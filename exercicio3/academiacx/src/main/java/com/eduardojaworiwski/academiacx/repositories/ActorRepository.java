package com.eduardojaworiwski.academiacx.repositories;
import com.eduardojaworiwski.academiacx.entity.ActorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorModel, Long>{
    
}
