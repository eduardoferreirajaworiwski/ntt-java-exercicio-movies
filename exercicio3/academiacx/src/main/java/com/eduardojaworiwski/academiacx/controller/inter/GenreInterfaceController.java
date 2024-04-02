package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.GenreModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreInterfaceController {

    ResponseEntity<List<GenreModel>> getAllGenres();

    ResponseEntity<GenreModel> getGenreById(Long id);

    ResponseEntity<GenreModel> createGenre(GenreModel genre);

    ResponseEntity<GenreModel> updateGenre(Long id, GenreModel updatedGenre);

    ResponseEntity<Void> deleteGenre(Long id);
}
