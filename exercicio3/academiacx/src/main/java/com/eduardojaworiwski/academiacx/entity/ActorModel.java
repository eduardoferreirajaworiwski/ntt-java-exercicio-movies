package com.eduardojaworiwski.academiacx.entity;

import jakarta.persistence.*;
import com.eduardojaworiwski.academiacx.entity.MovieModel;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actors")
public class ActorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 50)
    private String nationality;

    @ManyToMany(mappedBy = "actors")
    private List<MovieModel> movies;

    // Constructors
    public ActorModel() {
    }

    public ActorModel(String name, Date birthDate, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
