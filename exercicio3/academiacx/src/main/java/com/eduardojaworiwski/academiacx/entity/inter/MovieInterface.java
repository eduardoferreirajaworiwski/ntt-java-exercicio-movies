package com.eduardojaworiwski.academiacx.entity.inter;

import com.eduardojaworiwski.academiacx.entity.*;

import java.time.Year;
import java.util.Date;
import java.util.List;

public interface MovieInterface {
    Long getImdbID();
    String getTitle();
    Date getReleased();
    Double getRuntime();
    String getPlot();
    String getLanguage();
    String getCountry();
    String getAwards();
    String getPoster();
    Year getYear();
    GenreModel getGenre();
    StudioModel getStudio();
    FranchiseModel getFranchise();
    List<ActorModel> getActors();
    List<DirectorModel> getDirectors();
    List<StreamingModel> getStreamings();

    void setImdbID(Long imdbID);
    void setTitle(String title);
    void setReleased(Date released);
    void setRuntime(Double runtime);
    void setPlot(String plot);
    void setLanguage(String language);
    void setCountry(String country);
    void setAwards(String awards);
    void setPoster(String poster);
    void setGenre(GenreModel genre);
    void setStudio(StudioModel studio);
    void setFranchise(FranchiseModel franchise);
    void setActors(List<ActorModel> actors);
    void setDirectors(List<DirectorModel> directors);
    void setStreamings(List<StreamingModel> streamings);
}
