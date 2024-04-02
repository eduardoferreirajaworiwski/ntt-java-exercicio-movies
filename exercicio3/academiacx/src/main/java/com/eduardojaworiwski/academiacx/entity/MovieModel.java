package com.eduardojaworiwski.academiacx.entity;

import jakarta.persistence.*;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.eduardojaworiwski.academiacx.entity.inter.MovieInterface;

@Entity
@Table(name = "movies")
public class MovieModel implements MovieInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Date released;

    @Column(nullable = false)
    private Double runtime;

    @Column(length = 500)
    private String plot;

    @Column(nullable = false, length = 50)
    private String language;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(length = 50)
    private String awards;

    @Column(length = 100)
    private String poster;

    @ManyToOne
    private GenreModel genre;

    @ManyToOne
    private StudioModel studio;

    @ManyToOne
    private FranchiseModel franchise;

    @ManyToMany
    private List<ActorModel> actors;

    @ManyToMany
    private List<DirectorModel> directors;

    @ManyToMany
    private List<StreamingModel> streamings;

    // Getters and setters
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

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Double getRuntime() {
        return runtime;
    }

    public void setRuntime(Double runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Year getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(released);
        return Year.of(calendar.get(Calendar.YEAR));
    }

    public GenreModel getGenre() {
        return genre;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public StudioModel getStudio() {
        return studio;
    }

    public void setStudio(StudioModel studio) {
        this.studio = studio;
    }

    public FranchiseModel getFranchise() {
        return franchise;
    }

    public void setFranchise(FranchiseModel franchise) {
        this.franchise = franchise;
    }

    public List<ActorModel> getActors() {
        return actors;
    }

    public void setActors(List<ActorModel> actors) {
        this.actors = actors;
    }

    public List<DirectorModel> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorModel> directors) {
        this.directors = directors;
    }

    public List<StreamingModel> getStreamings() {
        return streamings;
    }

    @Override
    public void setImdbID(Long imdbID) {
        
    }

    public void setStreamings(List<StreamingModel> streamings) {
        this.streamings = streamings;
    }

    // Implementação do método da interface MovieInterface
    @Override
    public Long getImdbID() {
        return id;
    }
}
