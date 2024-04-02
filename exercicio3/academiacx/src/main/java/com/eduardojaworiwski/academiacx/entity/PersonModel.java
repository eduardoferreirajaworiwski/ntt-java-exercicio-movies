package com.eduardojaworiwski.academiacx.entity;

import com.eduardojaworiwski.academiacx.entity.inter.PersonInterface;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class PersonModel implements PersonInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false, length = 50)
    private String nationality;

    // Constructors
    public PersonModel() {
    }

    public PersonModel(String name, Date birthdate, String nationality) {
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
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

    @Override
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
