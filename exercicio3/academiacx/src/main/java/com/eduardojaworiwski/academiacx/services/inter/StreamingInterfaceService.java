package com.eduardojaworiwski.academiacx.services.inter;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;

import java.util.List;
import java.util.Optional;

public interface StreamingInterfaceService {
    List<StreamingModel> list();

    Optional<StreamingModel> findById(Long id);

    StreamingModel create(StreamingModel streaming);

    StreamingModel update(StreamingModel streaming);

    void delete(Long id);
}
