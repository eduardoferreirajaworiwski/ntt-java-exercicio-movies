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

import com.eduardojaworiwski.academiacx.entity.StreamingModel;
import com.eduardojaworiwski.academiacx.services.StreamingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/streaming")
public class StreamingController {
    
    @Autowired
    StreamingService streamingService;

    @GetMapping("/list")
    public ResponseEntity<List<StreamingModel>> listStreamings() {
        return ResponseEntity.ok(streamingService.listStreaming());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingModel> getStreaming(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(streamingService.getStreaming(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<StreamingModel> registerStreaming(@RequestBody StreamingModel streamingModel) {
        try {
            return ResponseEntity.ok(streamingService.registerStreaming(streamingModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PutMapping("/update")

    public ResponseEntity<StreamingModel> updateStreaming(@RequestBody StreamingModel streamingModel) {
        try {
            return ResponseEntity.ok(streamingService.updateStreaming(streamingModel));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStreaming(@PathVariable Long id) {
        try {
            streamingService.deleteStreaming(id);
            return ResponseEntity.ok("Streaming deleted successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    

}
