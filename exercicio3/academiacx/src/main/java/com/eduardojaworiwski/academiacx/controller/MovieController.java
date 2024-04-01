package com.eduardojaworiwski.academiacx.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eduardojaworiwski.academiacx.entity.MovieModel;
import com.eduardojaworiwski.academiacx.services.MovieService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    MovieService movieService;


    @GetMapping("/list")
    public ResponseEntity<List<MovieModel>> listMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovie(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(movieService.getMovie(id).get());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<MovieModel> registerMovie(@RequestBody MovieModel movieModel) {
        try {
            return ResponseEntity.ok(movieService.registerMovie(movieModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<MovieModel> updateMovie(@RequestBody MovieModel movieModel) {
        try {
            return ResponseEntity.ok(movieService.updateMovie(movieModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(movieService.deleteMovie(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
