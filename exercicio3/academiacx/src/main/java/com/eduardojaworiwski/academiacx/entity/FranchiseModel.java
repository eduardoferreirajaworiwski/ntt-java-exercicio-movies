package com.eduardojaworiwski.academiacx.entity;

import com.eduardojaworiwski.academiacx.entity.inter.FranchiseInterface;
import jakarta.persistence.*;
import com.eduardojaworiwski.academiacx.entity.MovieModel;
import java.util.List;

@Entity
@Table(name = "franchises")
public class FranchiseModel implements FranchiseInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "franchise")
    private List<MovieModel> movies;

    // Constructors
    public FranchiseModel() {
    }

    public FranchiseModel(String name) {
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
