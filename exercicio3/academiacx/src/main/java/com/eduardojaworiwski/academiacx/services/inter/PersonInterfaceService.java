package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonInterfaceService {
    List<PersonModel> list();

    Optional<PersonModel> findById(Long id);

    PersonModel create(PersonModel person);

    PersonModel update(PersonModel person);

    void delete(Long id);
}
