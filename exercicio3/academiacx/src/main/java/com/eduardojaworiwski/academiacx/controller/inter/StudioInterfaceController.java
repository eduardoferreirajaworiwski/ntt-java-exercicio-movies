package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.StudioModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudioInterfaceController {

    ResponseEntity<List<StudioModel>> getAllStudios();

    ResponseEntity<StudioModel> getStudioById(Long id);

    ResponseEntity<StudioModel> createStudio(StudioModel studio);

    ResponseEntity<StudioModel> updateStudio(Long id, StudioModel updatedStudio);

    ResponseEntity<Void> deleteStudio(Long id);
}
