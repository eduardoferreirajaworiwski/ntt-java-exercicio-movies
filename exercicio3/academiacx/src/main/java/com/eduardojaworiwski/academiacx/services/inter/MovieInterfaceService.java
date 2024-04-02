package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieInterfaceService {
    List<MovieModel> list();

    Optional<MovieModel> findById(Long id);

    MovieModel create(MovieModel movie);

    MovieModel update(MovieModel movie);

    void delete(Long id);
}
