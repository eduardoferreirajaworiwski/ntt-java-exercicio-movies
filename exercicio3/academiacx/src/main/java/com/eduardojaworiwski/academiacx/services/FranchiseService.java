package com.eduardojaworiwski.academiacx.services;


import com.eduardojaworiwski.academiacx.services.inter.FranchiseInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import com.eduardojaworiwski.academiacx.repository.FranchiseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService implements FranchiseInterfaceService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public List<FranchiseModel> list() {
        return franchiseRepository.findAll();
    }

    @Override
    public Optional<FranchiseModel> findById(Long id) {
        return franchiseRepository.findById(id);
    }

    @Override
    public FranchiseModel create(FranchiseModel franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public FranchiseModel update(FranchiseModel franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void delete(Long id) {
        franchiseRepository.deleteById(id);
    }
}