package com.eduardojaworiwski.academiacx.dto.inter;

import com.eduardojaworiwski.academiacx.dto.*;

import java.util.Date;
import java.util.List;

public interface MovieInterfaceDTO {
    Long getId();
    String getTitle();
    Date getReleased();
    Double getRuntime();
    String getPlot();
    String getLanguage();
    String getCountry();
    String getAwards();
    String getPoster();
    GenreDTO getGenre();
    StudioDTO getStudio();
    FranchiseDTO getFranchise();
    List<ActorDTO> getActors();
    List<DirectorDTO> getDirectors();
    List<StreamingDTO> getStreamings();

    void setId(Long id);
    void setTitle(String title);
    void setReleased(Date released);
    void setRuntime(Double runtime);
    void setPlot(String plot);
    void setLanguage(String language);
    void setCountry(String country);
    void setAwards(String awards);
    void setPoster(String poster);
    void setGenre(GenreDTO genre);
    void setStudio(StudioDTO studio);
    void setFranchise(FranchiseDTO franchise);
    void setActors(List<ActorDTO> actors);
    void setDirectors(List<DirectorDTO> directors);
    void setStreamings(List<StreamingDTO> streamings);
}
