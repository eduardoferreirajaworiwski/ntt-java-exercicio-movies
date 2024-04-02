package com.eduardojaworiwski.academiacx.entity.inter;

import com.eduardojaworiwski.academiacx.entity.MovieModel;

import java.util.Date;
import java.util.List;

public interface ActorInterface {
    /* Getters */
    Long getId();
    String getName();
    Date getBirthDate();
    String getCountry();
    List<MovieModel> getMovies();

    /* Setters */
    void setName(String name);
    void setBirthDate(Date birthDate);
    void setCountry(String country);
    void setMovies(List<MovieModel> movies);
}
