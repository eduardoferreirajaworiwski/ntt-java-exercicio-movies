package com.eduardojaworiwski.academiacx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eduardojaworiwski.academiacx.dto.ActorDTO;
import com.eduardojaworiwski.academiacx.entity.ActorModel;
import com.eduardojaworiwski.academiacx.services.ActorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/list")
    public ResponseEntity<List<ActorDTO>> listActors() {
        return ResponseEntity.ok(actorService.listActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(actorService.getActor(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ActorModel> registerActor(@RequestBody ActorModel actorModel) {
        try {
            return ResponseEntity.ok(actorService.registerActor(actorModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ActorModel> updateActor(@RequestBody ActorModel actor) {
        try {
            return ResponseEntity.ok(actorService.updateActor(actor));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(actorService.deleteActor(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
