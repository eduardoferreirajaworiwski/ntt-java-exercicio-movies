package com.eduardojaworiwski.academiacx.dto.inter;

import com.eduardojaworiwski.academiacx.dto.MovieDTO;

import java.util.List;

public interface FranchiseInterfaceDTO {
    Long getId();
    String getName();
    List<MovieDTO> getMovies();

    void setId(Long id);
    void setName(String name);
    void setMovies(List<MovieDTO> movies);
}
