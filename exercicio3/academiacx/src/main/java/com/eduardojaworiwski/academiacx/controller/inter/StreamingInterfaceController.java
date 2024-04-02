package com.eduardojaworiwski.academiacx.controller.inter;

import com.eduardojaworiwski.academiacx.entity.StreamingModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StreamingInterfaceController {

    ResponseEntity<List<StreamingModel>> getAllStreamings();

    ResponseEntity<StreamingModel> getStreamingById(Long id);

    ResponseEntity<StreamingModel> createStreaming(StreamingModel streaming);

    ResponseEntity<StreamingModel> updateStreaming(Long id, StreamingModel updatedStreaming);

    ResponseEntity<Void> deleteStreaming(Long id);
}
