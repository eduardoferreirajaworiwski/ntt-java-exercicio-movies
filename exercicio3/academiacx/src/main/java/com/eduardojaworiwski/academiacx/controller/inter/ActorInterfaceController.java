package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.ActorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActorInterfaceController {

    ResponseEntity<List<ActorModel>> getAllActors();

    ResponseEntity<ActorModel> getActorById(Long id);

    ResponseEntity<ActorModel> createActor(ActorModel actor);

    ResponseEntity<ActorModel> updateActor(Long id, ActorModel updatedActor);

    ResponseEntity<Void> deleteActor(Long id);
}
