package com.eduardojaworiwski.academiacx.services;


import com.eduardojaworiwski.academiacx.services.inter.DirectorInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import com.eduardojaworiwski.academiacx.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService implements DirectorInterfaceService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorModel> list() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<DirectorModel> findById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public DirectorModel create(DirectorModel director) {
        return directorRepository.save(director);
    }

    @Override
    public DirectorModel update(DirectorModel director) {
        return directorRepository.save(director);
    }

    @Override
    public void delete(Long id) {
        directorRepository.deleteById(id);
    }
}

