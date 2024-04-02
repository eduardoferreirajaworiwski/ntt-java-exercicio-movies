package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.MovieModel;
import com.eduardojaworiwski.academiacx.repository.MovieRepository;
import com.eduardojaworiwski.academiacx.services.inter.MovieInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieInterfaceService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieModel> list() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieModel> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public MovieModel create(MovieModel movie) {
        return movieRepository.save(movie);
    }

    @Override
    public MovieModel update(MovieModel movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
