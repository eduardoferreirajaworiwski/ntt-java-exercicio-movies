package com.eduardojaworiwski.academiacx.controller;

import com.eduardojaworiwski.academiacx.controller.inter.MovieInterfaceController;
import com.eduardojaworiwski.academiacx.entity.MovieModel;
import com.eduardojaworiwski.academiacx.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController implements MovieInterfaceController {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        List<MovieModel> movies = movieRepository.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable Long id) {
        Optional<MovieModel> movie = movieRepository.findById(id);
        return movie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<MovieModel> createMovie(@RequestBody MovieModel movie) {
        MovieModel newMovie = movieRepository.save(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(@PathVariable Long id, @RequestBody MovieModel updatedMovie) {
        if (!movieRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedMovie.setId(id);
        MovieModel savedMovie = movieRepository.save(updatedMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (!movieRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
