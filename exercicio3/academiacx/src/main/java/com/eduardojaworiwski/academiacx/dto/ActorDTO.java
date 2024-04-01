package com.eduardojaworiwski.academiacx.dto;

import java.time.LocalDate;
import java.util.List;
import com.eduardojaworiwski.academiacx.entity.ActorModel;
import com.eduardojaworiwski.academiacx.entity.MovieModel;

public record ActorDTO(
        Long id,
        String name,
        String gender,
        LocalDate birthDate,
        List<String> movies) {
    public ActorModel toActor() {
        ActorModel actorModel = new ActorModel();
        actorModel.setId(this.id());
        actorModel.setName(this.name());
        actorModel.setGender(this.gender());
        actorModel.setBirthDate(this.birthDate());

        List<MovieModel> actorMovieList = this.movies().stream().map(title -> {
            MovieModel movieModel = new MovieModel();
            movieModel.setTitle(title);
            return movieModel;
        }).toList();
        actorModel.setMovies(actorMovieList);
        return actorModel;
    }

}
