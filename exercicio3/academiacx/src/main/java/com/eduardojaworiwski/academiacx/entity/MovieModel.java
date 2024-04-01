package com.eduardojaworiwski.academiacx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
public class MovieModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String title;

    @ManyToOne
    @JoinColumn(name ="genre_id")
    private GenreModel genre;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private StudioModel studio;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    @JsonIgnore
    private FranchiseModel franchise;

    @ManyToMany
    @JoinTable(name = "director_movie", joinColumns = @JoinColumn(name = "director_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<DirectorModel> directors;
  
    @ManyToMany(mappedBy = "movies")
    private List<StreamingModel> streaming;
  
    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorModel> actors;
}
