package com.eduardojaworiwski.academiacx.services;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import com.eduardojaworiwski.academiacx.entity.MovieModel;
import com.eduardojaworiwski.academiacx.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;

public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieModel> listMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieModel> getMovieId(@NotNull @Valid Long id) {
        
        Optional<MovieModel> optionalMovieModel = movieRepository.findById(id);
        if(optionalMovieModel.isEmpty()) {
            return null;
        }
        return Optional.of(optionalMovieModel.get());
    }
    
    public MovieModel registerMovie(MovieModel movieModel) {
        if(movieModel.getId() != null) {
            return null;
        }
        return movieRepository.save(movieModel);
    }

    public MovieModel updateMovie(MovieModel movieModel) {
        MovieModel updateMovie = movieRepository.findById(movieModel.getId()).get();
        updateMovie.setTitle(movieModel.getTitle());
        MovieModel updatedMovie = movieRepository.save(updateMovie);
        return updatedMovie;
    }

    public String deleteMovie(@NotNull @Valid Long id) {
        MovieModel deletedMovie = getMovieId(id).get();
        if (deletedMovie == null) {
            return "Error by id" + id;
        }
        movieRepository.deleteById(id);
        return "Deleted";
    }

}
