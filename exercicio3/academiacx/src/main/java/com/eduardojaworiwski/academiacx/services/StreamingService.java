package com.eduardojaworiwski.academiacx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduardojaworiwski.academiacx.repositories.StreamingRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;

public class StreamingService {
    

    @Autowired
    StreamingRepository streamingRepository;


    public List<StreamingModel> listStreaming() {
        return streamingRepository.findAll();
    }

    public StreamingModel getStreaming(@NotNull @Valid Long id) {
        if (id == null) {
            return null;
        }
        Optional<StreamingModel> optionalStreamingModel = streamingRepository.findById(id);

        if (optionalStreamingModel.isEmpty()) {
            return null;
        }
        return optionalStreamingModel.get();
    }

    public StreamingModel registerStreaming(StreamingModel streamingModel) {
        if(streamingModel.getId() != null) {
            return null;
        }
        return streamingRepository.save(streamingModel);
    }

    public StreamingModel updateStreaming(StreamingModel streamingModel) {
        if (streamingModel.getId() == null) {
            return null;
        }
        StreamingModel streaming = streamingRepository.findById(streamingModel.getId()).get();
        streaming.setName(streamingModel.getName());
        streaming.setMovies(streamingModel.getMovies());
        StreamingModel updatedStreaming = streamingRepository.save(streaming);
        return updatedStreaming;
    }

    public String deleteStreaming(@NotNull @Valid Long id) {
        StreamingModel deletedStreaming = getStreaming(id);
            if (deletedStreaming == null) {
                return "Error by id" + id;
            }
            streamingRepository.deleteById(id);
            return "Deleted";
    }
}
