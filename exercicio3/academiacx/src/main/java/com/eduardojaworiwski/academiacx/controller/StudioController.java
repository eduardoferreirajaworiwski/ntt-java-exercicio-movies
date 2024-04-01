package com.eduardojaworiwski.academiacx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eduardojaworiwski.academiacx.entity.StudioModel;
import com.eduardojaworiwski.academiacx.services.StudioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping
public class StudioController {
    
    @Autowired
    StudioService studioService;

    @GetMapping("/list")
    public ResponseEntity<List<StudioModel>> listStudios() {
        return ResponseEntity.ok(studioService.listStudios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudioModel> getStudio(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studioService.getStudio(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<StudioModel> registerStudio(@RequestBody StudioModel studioModel) {
        try {
            return ResponseEntity.ok(studioService.registerStudio(studioModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")
    public ResponseEntity<StudioModel> updateStudio(@RequestBody StudioModel studioModel) {
        try {
            return ResponseEntity.ok(studioService.updateStudio(studioModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudio(@PathVariable Long id) {
        try {
            studioService.deleteStudio(id);
            return ResponseEntity.ok("Studio deleted successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
