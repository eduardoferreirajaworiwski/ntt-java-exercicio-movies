package com.eduardojaworiwski.academiacx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardojaworiwski.academiacx.entity.ActorModel;

import com.eduardojaworiwski.academiacx.repositories.ActorRepository;
import com.eduardojaworiwski.academiacx.dto.ActorDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class ActorService {
   
    @Autowired
    ActorRepository actorRepository;

    public List<ActorDTO> listActors() {
        return actorRepository.findAll().stream().map(actorModel -> new ActorDTO(
            actorModel.getId(),
            actorModel.getName(),
            actorModel.getGender(),
            actorModel.getBirthDate(),
            actorModel.getMovies().stream().map(movie -> movie.getTitle()).toList())).toList();

    }

    public ActorDTO getActor(@NotNull @Valid Long id) {
        Optional<ActorModel> optionalActorModel = actorRepository.findById(id);
        
        ActorDTO result = new ActorDTO(
            optionalActorModel.get().getId(),
            optionalActorModel.get().getName(),
            optionalActorModel.get().getGender(),
            optionalActorModel.get().getBirthDate(),
            optionalActorModel.get().getMovies().stream().map(movie -> movie.getTitle()).toList()
        );
        return result;
    }
    

    public ActorModel registerActor(ActorModel actorModel) {
        if(actorModel.getId() != null) {
            throw new RuntimeException("Invalid ID"); 
        }
        return actorRepository.save(actorModel);
    }
    public ActorModel updateActor(ActorModel actorModel) {
        @SuppressWarnings("null")
        ActorModel actor = actorRepository.findById(actorModel.getId()).get();
        actor.setName(actorModel.getName());
        ActorModel updatedActor = actorRepository.save(actor);
        return updatedActor;
    }

    @SuppressWarnings("null")
    public String deleteActor(@NotNull @Valid Long id){
        ActorModel deleteActor = getActor(id).toActor();
        String name = deleteActor.getName();
        actorRepository.delete(deleteActor);
        return "Actor " + name + " deleted successfully";
    }
}
