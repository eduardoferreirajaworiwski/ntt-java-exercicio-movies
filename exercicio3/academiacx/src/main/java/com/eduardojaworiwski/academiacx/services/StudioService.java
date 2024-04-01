package com.eduardojaworiwski.academiacx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.eduardojaworiwski.academiacx.repositories.StudioRepository;
import com.eduardojaworiwski.academiacx.entity.StudioModel;

public class StudioService {
    
    @Autowired
    StudioRepository studioRepository;

    public List<StudioModel> listStudios() {
        return studioRepository.findAll();
    }

    public StudioModel getStudio(Long id) {
        if (id == null) {
            return null;
        }
        return studioRepository.findById(id).get();
    }

    public StudioModel registerStudio(StudioModel studioModel) {
        if(studioModel.getId() != null) {
            return null;
        }
        return studioRepository.save(studioModel);
    }

    public StudioModel updateStudio(StudioModel studioModel) {
        if (studioModel.getId() == null) {
            return null;
        }
        StudioModel studio = studioRepository.findById(studioModel.getId()).get();
        studio.setName(studioModel.getName());
        studio.setMovies(studioModel.getMovies());
        StudioModel updatedStudio = studioRepository.save(studio);
        return updatedStudio;
    }


    public String deleteStudio(Long id) {
        StudioModel deletedStudio = getStudio(id);
            if (deletedStudio == null) {
                return "Error by id" + id;
            }
            studioRepository.deleteById(id);
            return "Deleted";
    }

}
