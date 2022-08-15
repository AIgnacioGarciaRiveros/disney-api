package com.alkemy.disney.disney.service;


import com.alkemy.disney.disney.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    FilmDTO save(FilmDTO filmDTO);
    List<FilmDTO> getAll();
    FilmDTO getById(Long id)throws Exception;
    FilmDTO update(FilmDTO filmDTO,Long id) throws Exception;
    void delete(Long id) throws Exception;
}
