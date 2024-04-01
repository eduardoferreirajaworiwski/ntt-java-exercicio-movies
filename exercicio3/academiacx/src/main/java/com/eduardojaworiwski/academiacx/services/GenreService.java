package com.eduardojaworiwski.academiacx.services;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import com.eduardojaworiwski.academiacx.repositories.GenreRepository;
import com.eduardojaworiwski.academiacx.entity.GenreModel;

import org.springframework.beans.factory.annotation.Autowired;



public class GenreService {
    
    @Autowired
    GenreRepository genreRepository;

    public List<GenreModel> listGenres() {
        return genreRepository.findAll();
    }

    public GenreModel getGenre(@NotNull @Valid Long id) {
        if (id == null) {
            return null;
        }
        Optional<GenreModel> optionalGenreModel = genreRepository.findById(id);

        if (optionalGenreModel.isEmpty()) {
            return null;
        }

        return optionalGenreModel.get();

    }

    public GenreModel registerGenre(GenreModel genreModel) {
        if(genreModel.getId() != null) {
            return null;
        }
        return genreRepository.save(genreModel);
    }

    public GenreModel updateGenre(GenreModel genreModel) {
        if (genreModel.getId() == null) {
            return null;
        }
        GenreModel genre = genreRepository.findById(genreModel.getId()).get();
        genre.setName(genreModel.getName());
        GenreModel updatedGenre = genreRepository.save(genre);
        return updatedGenre;
    }

    public String deleteGenre(@NotNull @Valid Long id) {
        GenreModel deletedGenre = getGenre(id);
            if (deletedGenre == null) {
                return "Error by id" + id;
            }
            genreRepository.deleteById(id);
            return "Deleted";
    }
}
