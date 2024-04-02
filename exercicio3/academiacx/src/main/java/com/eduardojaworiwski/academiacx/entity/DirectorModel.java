package com.eduardojaworiwski.academiacx.entity;

import com.eduardojaworiwski.academiacx.entity.inter.DirectorInterface;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;

@Setter
@Entity
@Table(name = "directors")
public class DirectorModel implements DirectorInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false, length = 50)
    private String nationality;

    // Construtores
    public DirectorModel() {
    }

    public DirectorModel(String name, Date birthdate, String nationality) {
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    // Getters e Setters
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

}
