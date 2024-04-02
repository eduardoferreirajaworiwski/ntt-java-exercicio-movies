package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.PersonModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonInterfaceController {

    ResponseEntity<List<PersonModel>> getAllPersons();

    ResponseEntity<PersonModel> getPersonById(Long id);

    ResponseEntity<PersonModel> createPerson(PersonModel person);

    ResponseEntity<PersonModel> updatePerson(Long id, PersonModel updatedPerson);

    ResponseEntity<Void> deletePerson(Long id);
}
