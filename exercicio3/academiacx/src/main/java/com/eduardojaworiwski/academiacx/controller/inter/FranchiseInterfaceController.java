package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FranchiseInterfaceController {

    ResponseEntity<List<FranchiseModel>> getAllFranchises();

    ResponseEntity<FranchiseModel> getFranchiseById(Long id);

    ResponseEntity<FranchiseModel> createFranchise(FranchiseModel franchise);

    ResponseEntity<FranchiseModel> updateFranchise(Long id, FranchiseModel updatedFranchise);

    ResponseEntity<Void> deleteFranchise(Long id);
}
