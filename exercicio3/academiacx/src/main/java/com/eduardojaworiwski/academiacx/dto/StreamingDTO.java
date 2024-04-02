package com.eduardojaworiwski.academiacx.dto;

public class StreamingDTO {
    private Long id;
    private String name;
    private String platform;

    // Constructors
    public StreamingDTO() {
    }

    public StreamingDTO(Long id, String name, String platform) {
        this.id = id;
        this.name = name;
        this.platform = platform;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
