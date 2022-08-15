package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAllGenres();
}
