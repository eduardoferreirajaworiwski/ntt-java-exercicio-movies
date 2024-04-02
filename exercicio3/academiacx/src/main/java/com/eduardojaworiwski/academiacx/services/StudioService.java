package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.StudioModel;
import com.eduardojaworiwski.academiacx.repository.StudioRepository;
import com.eduardojaworiwski.academiacx.services.inter.StudioInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService implements StudioInterfaceService {

    @Autowired
    private StudioRepository studioRepository;

    @Override
    public List<StudioModel> list() {
        return studioRepository.findAll();
    }

    @Override
    public Optional<StudioModel> findById(Long id) {
        return studioRepository.findById(id);
    }

    @Override
    public StudioModel create(StudioModel studio) {
        return studioRepository.save(studio);
    }

    @Override
    public StudioModel update(StudioModel studio) {
        return studioRepository.save(studio);
    }

    @Override
    public void delete(Long id) {
        studioRepository.deleteById(id);
    }
}
