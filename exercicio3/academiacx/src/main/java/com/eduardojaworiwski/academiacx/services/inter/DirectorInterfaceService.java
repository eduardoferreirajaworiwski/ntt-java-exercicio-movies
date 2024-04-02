package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.DirectorModel;

import java.util.List;
import java.util.Optional;

public interface DirectorInterfaceService {
    List<DirectorModel> list();
    Optional<DirectorModel> findById(Long id);
    DirectorModel create(DirectorModel director);
    DirectorModel update(DirectorModel director);
    void delete(Long id);
}
