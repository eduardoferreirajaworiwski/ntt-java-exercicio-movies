package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.services.inter.GenreInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eduardojaworiwski.academiacx.entity.GenreModel;
import com.eduardojaworiwski.academiacx.repository.GenreRepository;


import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements GenreInterfaceService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreModel> list() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<GenreModel> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public GenreModel create(GenreModel genre) {
        return genreRepository.save(genre);
    }

    @Override
    public GenreModel update(GenreModel genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
