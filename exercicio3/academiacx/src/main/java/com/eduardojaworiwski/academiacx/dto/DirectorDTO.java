package com.eduardojaworiwski.academiacx.dto;

import java.util.Date;

public class DirectorDTO {
    private Long id;
    private String name;
    private Date birthdate;
    private String nationality;

    // Constructors
    public DirectorDTO() {
    }

    public DirectorDTO(Long id, String name, Date birthdate, String nationality) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    // Getters and Setters
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
