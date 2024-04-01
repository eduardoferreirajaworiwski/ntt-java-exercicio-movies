package com.eduardojaworiwski.academiacx.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "director")
@Data
@NoArgsConstructor
public class DirectorModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank
    private String Name;
    private String gender;
    private String nationality;
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "directors")
    @JsonIgnore
    private List<MovieModel> movies;
}
