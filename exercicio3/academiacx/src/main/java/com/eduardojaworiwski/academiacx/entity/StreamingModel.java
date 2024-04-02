package com.eduardojaworiwski.academiacx.entity;

import com.eduardojaworiwski.academiacx.entity.inter.StreamingInterface;
import jakarta.persistence.*;
import com.eduardojaworiwski.academiacx.entity.MovieModel;

import java.util.List;

@Entity
@Table(name = "streamings")
public class StreamingModel implements StreamingInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    // Constructors
    public StreamingModel() {
    }

    public StreamingModel(String name) {
        this.name = name;
    }

    // Getters and setters
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}