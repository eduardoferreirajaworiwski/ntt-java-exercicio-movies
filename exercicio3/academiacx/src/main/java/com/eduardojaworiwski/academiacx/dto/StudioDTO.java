package com.eduardojaworiwski.academiacx.dto;

public class StudioDTO {
    private Long id;
    private String name;
    private String country;

    // Constructors
    public StudioDTO() {
    }

    public StudioDTO(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
