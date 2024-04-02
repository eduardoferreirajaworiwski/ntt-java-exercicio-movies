package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;

import java.util.List;
import java.util.Optional;

public interface FranchiseInterfaceService {
    List<FranchiseModel> list();

    Optional<FranchiseModel> findById(Long id);

    FranchiseModel create(FranchiseModel franchise);

    FranchiseModel update(FranchiseModel franchise);

    void delete(Long id);
}
