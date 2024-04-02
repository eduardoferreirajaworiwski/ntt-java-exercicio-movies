package com.eduardojaworiwski.academiacx.controller;

import com.eduardojaworiwski.academiacx.controller.inter.StudioInterfaceController;
import com.eduardojaworiwski.academiacx.entity.StudioModel;
import com.eduardojaworiwski.academiacx.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studios")
public class StudioController implements StudioInterfaceController {

    @Autowired
    private StudioRepository studioRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<StudioModel>> getAllStudios() {
        List<StudioModel> studios = studioRepository.findAll();
        return new ResponseEntity<>(studios, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudioModel> getStudioById(@PathVariable Long id) {
        Optional<StudioModel> studio = studioRepository.findById(id);
        return studio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<StudioModel> createStudio(@RequestBody StudioModel studio) {
        StudioModel newStudio = studioRepository.save(studio);
        return new ResponseEntity<>(newStudio, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StudioModel> updateStudio(@PathVariable Long id, @RequestBody StudioModel updatedStudio) {
        if (!studioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedStudio.setId(id);
        StudioModel savedStudio = studioRepository.save(updatedStudio);
        return new ResponseEntity<>(savedStudio, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudio(@PathVariable Long id) {
        if (!studioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
