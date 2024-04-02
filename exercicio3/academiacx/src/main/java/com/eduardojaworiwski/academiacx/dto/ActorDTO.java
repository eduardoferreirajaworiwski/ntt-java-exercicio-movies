package com.eduardojaworiwski.academiacx.dto;

import com.eduardojaworiwski.academiacx.dto.inter.ActorInterfaceDTO;

import java.util.Date;

public class ActorDTO implements ActorInterfaceDTO {
    private Long id;
    private String name;
    private Date birthdate;
    private String nationality;

    public ActorDTO() {
    }

    public ActorDTO(Long id, String name, Date birthdate, String nationality) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

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

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
