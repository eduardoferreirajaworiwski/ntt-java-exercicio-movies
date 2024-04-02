package com.eduardojaworiwski.academiacx.dto;

import java.util.Date;
import java.util.List;

public class MovieDTO {
    private Long id;
    private String title;
    private Date released;
    private Double runtime;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private GenreDTO genre;
    private StudioDTO studio;
    private FranchiseDTO franchise;
    private List<ActorDTO> actors;
    private List<DirectorDTO> directors;
    private List<StreamingDTO> streamings;

    // Constructors
    public MovieDTO() {
    }

    // Getters and setters (omitted for brevity)
}
