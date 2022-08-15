package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.entity.GenreEntity;
import com.alkemy.disney.disney.mapper.GenreMapper;
import com.alkemy.disney.disney.repository.GenreRepository;
import com.alkemy.disney.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;
//TODO:preguntar nombres metodo save genreEntity,genreEntitySaved,genreSavedDTO
    public GenreDTO save(GenreDTO genreDTO) {
        GenreEntity genreEntity= genreMapper.genreDTO2Entity(genreDTO);
        GenreEntity genreEntitySaved=genreRepository.save(genreEntity);
        GenreDTO genreSavedDTO=genreMapper.genreEntity2DTO(genreEntitySaved);
        return genreSavedDTO;
    }
    //TODO:preguntar nombres getallgenres de las 2 listas
    public List<GenreDTO> getAllGenres()
    {
        List<GenreEntity>genresList=genreRepository.findAll();
        List<GenreDTO> genresDTOList=genreMapper.genreEntityList2DTOList(genresList);
        return genresDTOList;
    }

}
