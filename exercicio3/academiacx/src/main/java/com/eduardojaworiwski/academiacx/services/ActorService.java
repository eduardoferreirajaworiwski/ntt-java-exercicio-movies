package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.ActorModel;
import com.eduardojaworiwski.academiacx.repository.ActorRepository;
import com.eduardojaworiwski.academiacx.services.inter.ActorInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements ActorInterfaceService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorModel> list() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<ActorModel> findById(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public ActorModel create(ActorModel actor) {
        return actorRepository.save(actor);
    }

    @Override
    public ActorModel update(ActorModel actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }
}
