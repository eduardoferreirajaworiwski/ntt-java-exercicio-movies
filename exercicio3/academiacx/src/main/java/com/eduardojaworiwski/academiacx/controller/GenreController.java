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

import com.eduardojaworiwski.academiacx.entity.GenreModel;
import com.eduardojaworiwski.academiacx.services.GenreService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/genre")
public class GenreController {
    
    @Autowired
    GenreService genreService;

    @GetMapping("/list")
    public ResponseEntity<List<GenreModel>> listGenres() {
        return ResponseEntity.ok(genreService.listGenres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreModel> getGenre(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(genreService.getGenre(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<GenreModel> registerGenre(@RequestBody GenreModel genreModel) {
        try {
            return ResponseEntity.ok(genreService.registerGenre(genreModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<GenreModel> updateGenre(@RequestBody GenreModel genreModel) {
        try {
            return ResponseEntity.ok(genreService.updateGenre(genreModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(genreService.deleteGenre(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
