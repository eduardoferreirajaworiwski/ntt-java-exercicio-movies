package com.eduardojaworiwski.academiacx.entity.inter;

import com.eduardojaworiwski.academiacx.entity.MovieModel;

import java.util.List;

public interface GenreInterface {
    Long getId();
    String getName();
    void setId(Long id);
    void setName(String name);
    List<MovieModel> getMovies();
    void setMovies(List<MovieModel> movies);
}
