package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import com.eduardojaworiwski.academiacx.repositories.DirectorRepository;
import com.eduardojaworiwski.academiacx.dto.DirectorDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public List<DirectorDTO> listDirectors() {
        return directorRepository.findAll().stream()
            .map(directorModel -> new DirectorDTO(
                directorModel.getId(),
                directorModel.getName(),
                directorModel.getGender(), // Add gender
                directorModel.getNationality(), // Add nationality
                directorModel.getBirthDate(), // Add birthDate
                directorModel.getMovies())) // Pass the list of movies directly
            .toList();

    }


    public DirectorDTO getDirector(@NotNull @Valid Long id) {
        Optional<DirectorModel> optionalDirectorModel = directorRepository.findById(id);
    
        DirectorDTO result = new DirectorDTO(
            optionalDirectorModel.get().getId(),
            optionalDirectorModel.get().getName(),
            optionalDirectorModel.get().getGender(),
            optionalDirectorModel.get().getNationality(),
            optionalDirectorModel.get().getBirthDate(),
            optionalDirectorModel.get().getMovies()
        );
        return result;
    }
    public DirectorModel registerDirector(DirectorModel directorModel) {
        if(directorModel.getId() != null) {
            throw new RuntimeException("Invalid ID"); 
        }
        return directorRepository.save(directorModel);
    }

    public DirectorModel updateDirector(DirectorModel directorModel) {
        @SuppressWarnings("null")
        DirectorModel director = directorRepository.findById(directorModel.getId()).get();
        director.setName(directorModel.getName());
        director.setGender(directorModel.getGender());
        director.setNationality(directorModel.getNationality());
        director.setBirthDate(directorModel.getBirthDate());
        director.setMovies(directorModel.getMovies());
        DirectorModel updatedDirector = directorRepository.save(director);
        return updatedDirector;
    }

    @SuppressWarnings("null")
    public String deleteDirector(@NotNull @Valid Long id){
        DirectorModel directorDeleted = getDirector(id).toDirector();
        String name = directorDeleted.getName();
        directorRepository.delete(directorDeleted);
        return "Director " + name + " deleted successfully";
    }
}
