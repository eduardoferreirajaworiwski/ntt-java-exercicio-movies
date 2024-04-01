package com.eduardojaworiwski.academiacx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eduardojaworiwski.academiacx.entity.FranchiseModel;
import com.eduardojaworiwski.academiacx.services.FranchiseService;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {
    
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("/list")
    public ResponseEntity<List<FranchiseModel>> listFranchises() {
        return ResponseEntity.ok(franchiseService.listFranchises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranchiseModel> getFranchise(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(franchiseService.getFranchise(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<FranchiseModel> registerFranchise(FranchiseModel franchiseModel) {
        try {
            return ResponseEntity.ok(franchiseService.registerFranchise(franchiseModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<FranchiseModel> updateFranchise(FranchiseModel franchiseModel) {
        try {
            return ResponseEntity.ok(franchiseService.updateFranchise(franchiseModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteFranchise(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(franchiseService.deleteFranchise(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
