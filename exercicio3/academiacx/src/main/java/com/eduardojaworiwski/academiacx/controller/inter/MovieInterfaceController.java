package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.MovieModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieInterfaceController {

    ResponseEntity<List<MovieModel>> getAllMovies();

    ResponseEntity<MovieModel> getMovieById(Long id);

    ResponseEntity<MovieModel> createMovie(MovieModel movie);

    ResponseEntity<MovieModel> updateMovie(Long id, MovieModel updatedMovie);

    ResponseEntity<Void> deleteMovie(Long id);
}
