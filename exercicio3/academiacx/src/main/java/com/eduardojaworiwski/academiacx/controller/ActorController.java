package com.eduardojaworiwski.academiacx.controller;

import com.eduardojaworiwski.academiacx.controller.inter.ActorInterfaceController;
import com.eduardojaworiwski.academiacx.entity.ActorModel;
import com.eduardojaworiwski.academiacx.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController implements ActorInterfaceController {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<ActorModel>> getAllActors() {
        List<ActorModel> actors = actorRepository.findAll();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ActorModel> getActorById(@PathVariable Long id) {
        Optional<ActorModel> actor = actorRepository.findById(id);
        return actor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<ActorModel> createActor(@RequestBody ActorModel actor) {
        ActorModel newActor = actorRepository.save(actor);
        return new ResponseEntity<>(newActor, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ActorModel> updateActor(@PathVariable Long id, @RequestBody ActorModel updatedActor) {
        if (!actorRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedActor.setId(id);
        ActorModel savedActor = actorRepository.save(updatedActor);
        return new ResponseEntity<>(savedActor, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        if (!actorRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        actorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
