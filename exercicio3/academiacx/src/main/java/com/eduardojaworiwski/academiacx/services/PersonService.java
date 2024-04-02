package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.PersonModel;
import com.eduardojaworiwski.academiacx.repository.PersonRepository;
import com.eduardojaworiwski.academiacx.services.inter.PersonInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonInterfaceService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonModel> list() {
        return personRepository.findAll();
    }

    @Override
    public Optional<PersonModel> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public PersonModel create(PersonModel person) {
        return personRepository.save(person);
    }

    @Override
    public PersonModel update(PersonModel person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
