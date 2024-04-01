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

import com.eduardojaworiwski.academiacx.dto.DirectorDTO;
import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import com.eduardojaworiwski.academiacx.services.DirectorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/director")
public class DirectorController {
    
    @Autowired
    DirectorService directorService;

    @GetMapping("/list")
    public ResponseEntity<List<DirectorDTO>> listDirectors() {
        return ResponseEntity.ok(directorService.listDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDTO> getDirector(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(directorService.getDirector(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DirectorModel> registerDirector(@RequestBody DirectorModel directorModel) {
        try {
            return ResponseEntity.ok(directorService.registerDirector(directorModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<DirectorModel> updateDirector(@RequestBody DirectorModel directorModel) {
        try {
            return ResponseEntity.ok(directorService.updateDirector(directorModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(directorService.deleteDirector(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
