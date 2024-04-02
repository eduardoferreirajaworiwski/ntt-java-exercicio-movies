package com.eduardojaworiwski.academiacx.controller;

import com.eduardojaworiwski.academiacx.controller.inter.PersonInterfaceController;
import com.eduardojaworiwski.academiacx.entity.PersonModel;
import com.eduardojaworiwski.academiacx.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController implements PersonInterfaceController {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPersons() {
        List<PersonModel> persons = personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> getPersonById(@PathVariable Long id) {
        Optional<PersonModel> person = personRepository.findById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<PersonModel> createPerson(@RequestBody PersonModel person) {
        PersonModel newPerson = personRepository.save(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PersonModel> updatePerson(@PathVariable Long id, @RequestBody PersonModel updatedPerson) {
        if (!personRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedPerson.setId(id);
        PersonModel savedPerson = personRepository.save(updatedPerson);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (!personRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
