package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.ActorModel;

import java.util.List;
import java.util.Optional;

public interface ActorInterfaceService {
    List<ActorModel> list();
    Optional<ActorModel> findById(Long id);
    ActorModel create(ActorModel actor);
    ActorModel update(ActorModel actor);
    void delete(Long id);
}
