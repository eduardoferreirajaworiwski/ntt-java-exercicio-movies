package com.eduardojaworiwski.academiacx.dto;

import java.time.LocalDate;
import java.util.List;
import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import com.eduardojaworiwski.academiacx.entity.MovieModel;

public record DirectorDTO(
    Long id,
    String name,
    String gender,
    String nationality,
    LocalDate birthDate,
    List<MovieModel> movies) {
        public DirectorModel toDirector() {
            DirectorModel directorModel = new DirectorModel();
            directorModel.setId(this.id);
            directorModel.setName(this.name);
            directorModel.setGender(this.gender);
            directorModel.setNationality(this.nationality);
            directorModel.setBirthDate(this.birthDate);
            
            List<MovieModel> directorMovieList = this.movies.stream().map(title -> {
                MovieModel movieModel = new MovieModel();
                movieModel.setTitle(title.getTitle()); // Fix: Use title.getTitle() to get the title string
                return movieModel;
            }).toList();
            directorModel.setMovies(directorMovieList);
            return directorModel;
        }
}