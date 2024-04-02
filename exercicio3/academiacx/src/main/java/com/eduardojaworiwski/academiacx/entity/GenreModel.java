package com.eduardojaworiwski.academiacx.entity;

import com.eduardojaworiwski.academiacx.entity.MovieModel;

import com.eduardojaworiwski.academiacx.entity.inter.GenreInterface;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenreModel implements GenreInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<MovieModel> movies;

    // Constructors
    public GenreModel() {
    }

    public GenreModel(String name) {
        this.name = name;
    }

    // Getters and setters
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
