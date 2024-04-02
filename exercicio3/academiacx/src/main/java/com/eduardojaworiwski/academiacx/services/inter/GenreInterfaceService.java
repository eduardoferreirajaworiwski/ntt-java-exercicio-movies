package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.GenreModel;

import java.util.List;
import java.util.Optional;

public interface GenreInterfaceService {
    List<GenreModel> list();

    Optional<GenreModel> findById(Long id);

    GenreModel create(GenreModel genre);

    GenreModel update(GenreModel genre);

    void delete(Long id);
}