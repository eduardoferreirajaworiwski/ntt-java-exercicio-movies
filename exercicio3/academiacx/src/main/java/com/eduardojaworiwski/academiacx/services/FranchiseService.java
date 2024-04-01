package com.eduardojaworiwski.academiacx.services;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import com.eduardojaworiwski.academiacx.repositories.FranchiseRepository;

@Service
public class FranchiseService {
    
    @Autowired
    FranchiseRepository franchiseRepository;

    public List<FranchiseModel> listFranchises() {
        return franchiseRepository.findAll();
    }

    public FranchiseModel getFranchise(@NotNull @Valid Long id) {
        if (id == null) {
            return null;
        }
        Optional<FranchiseModel> optionalFranchiseModel = franchiseRepository.findById(id);

        if (optionalFranchiseModel.isEmpty()) {
            return null;
        }

        return optionalFranchiseModel.get();

    }

    public FranchiseModel registerFranchise(FranchiseModel franchiseModel) {
        if(franchiseModel.getId() != null) {
            return null;
        }
        return franchiseRepository.save(franchiseModel);
    }

    public FranchiseModel updateFranchise(FranchiseModel franchiseModel) {
        if (franchiseModel.getId() == null) {
            return null;
        }
        FranchiseModel franchise = franchiseRepository.findById(franchiseModel.getId()).get();
        franchise.setName(franchiseModel.getName());
        franchise.setMovies(franchiseModel.getMovies());
        FranchiseModel updatedFranchise = franchiseRepository.save(franchise);
        return updatedFranchise;
    }
    @SuppressWarnings("null")
    public String deleteFranchise(@NotNull @Valid Long id) {
        FranchiseModel deletedFranchise = getFranchise(id);
            if (deletedFranchise == null) {
                return "Error by id" + id;
            }

            String franchiseDeletedSucess = deletedFranchise.getName();
            franchiseRepository.deleteById(id);
            return "Franchise deleted with success: " +franchiseDeletedSucess;
    }
}
