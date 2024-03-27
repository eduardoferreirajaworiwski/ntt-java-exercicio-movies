package com.example.academiacx.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_movie")
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private FranchiseModel franchise;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private StudioModel studio;

    @ManyToOne
    @JoinColumn(name = "streaming_id")
    private StreamingModel streaming;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public FranchiseModel getFranchise() {
        return franchise;
    }

    public void setFranchise(FranchiseModel franchise) {
        this.franchise = franchise;
    }

    public StudioModel getStudio() {
        return studio;
    }

    public void setStudio(StudioModel studio) {
        this.studio = studio;
    }

    public StreamingModel getStreaming() {
        return streaming;
    }

    public void setStreaming(StreamingModel streaming) {
        this.streaming = streaming;
    }
}
