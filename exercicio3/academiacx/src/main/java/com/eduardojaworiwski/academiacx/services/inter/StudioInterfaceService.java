package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.StudioModel;

import java.util.List;
import java.util.Optional;

public interface StudioInterfaceService {
    List<StudioModel> list();

    Optional<StudioModel> findById(Long id);

    StudioModel create(StudioModel studio);

    StudioModel update(StudioModel studio);

    void delete(Long id);
}
