package com.eduardojaworiwski.academiacx.services;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;
import com.eduardojaworiwski.academiacx.repository.StreamingRepository;
import com.eduardojaworiwski.academiacx.services.inter.StreamingInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService implements StreamingInterfaceService {

    @Autowired
    private StreamingRepository streamingRepository;

    @Override
    public List<StreamingModel> list() {
        return streamingRepository.findAll();
    }

    @Override
    public Optional<StreamingModel> findById(Long id) {
        return streamingRepository.findById(id);
    }

    @Override
    public StreamingModel create(StreamingModel streaming) {
        return streamingRepository.save(streaming);
    }

    @Override
    public StreamingModel update(StreamingModel streaming) {
        return streamingRepository.save(streaming);
    }

    @Override
    public void delete(Long id) {
        streamingRepository.deleteById(id);
    }
}
