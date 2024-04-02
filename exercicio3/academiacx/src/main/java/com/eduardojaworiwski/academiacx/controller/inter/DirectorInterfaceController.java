package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.DirectorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectorInterfaceController {

    ResponseEntity<List<DirectorModel>> getAllDirectors();

    ResponseEntity<DirectorModel> getDirectorById(Long id);

    ResponseEntity<DirectorModel> createDirector(DirectorModel director);

    ResponseEntity<DirectorModel> updateDirector(Long id, DirectorModel updatedDirector);

    ResponseEntity<Void> deleteDirector(Long id);
}
