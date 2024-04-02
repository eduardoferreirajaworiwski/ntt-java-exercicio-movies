package com.eduardojaworiwski.academiacx.controller;

import com.eduardojaworiwski.academiacx.controller.inter.StreamingInterfaceController;
import com.eduardojaworiwski.academiacx.entity.StreamingModel;
import com.eduardojaworiwski.academiacx.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/streamings")
public class StreamingController implements StreamingInterfaceController {

    @Autowired
    private StreamingRepository streamingRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<StreamingModel>> getAllStreamings() {
        List<StreamingModel> streamings = streamingRepository.findAll();
        return new ResponseEntity<>(streamings, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StreamingModel> getStreamingById(@PathVariable Long id) {
        Optional<StreamingModel> streaming = streamingRepository.findById(id);
        return streaming.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<StreamingModel> createStreaming(@RequestBody StreamingModel streaming) {
        StreamingModel newStreaming = streamingRepository.save(streaming);
        return new ResponseEntity<>(newStreaming, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StreamingModel> updateStreaming(@PathVariable Long id, @RequestBody StreamingModel updatedStreaming) {
        if (!streamingRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedStreaming.setId(id);
        StreamingModel savedStreaming = streamingRepository.save(updatedStreaming);
        return new ResponseEntity<>(savedStreaming, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        if (!streamingRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        streamingRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
