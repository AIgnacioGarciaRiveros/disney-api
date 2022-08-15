package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.FilmDTO;
import com.alkemy.disney.disney.entity.FilmEntity;
import com.alkemy.disney.disney.exception.ResourceNotFoundException;
import com.alkemy.disney.disney.mapper.FilmMapper;
import com.alkemy.disney.disney.repository.FilmRepository;
import com.alkemy.disney.disney.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
//TODO:TERMINAR SERVICE
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmRepository filmRepository;

    public FilmDTO save(FilmDTO filmDTO) {
        FilmEntity film = filmMapper.filmDTO2Entity(filmDTO);
        FilmEntity filmSaved = filmRepository.save(film);
        FilmDTO filmSavedDTO=filmMapper.filmEntity2DTO(filmSaved,Boolean.TRUE);
        return filmSavedDTO;
    }

    public List<FilmDTO> getAll() {
        List<FilmEntity>films=filmRepository.findAll();
        List<FilmDTO>filmsSaved=filmMapper.filmEntityList2DTOList(films,Boolean.TRUE);
        return filmsSaved;
    }

    public FilmDTO getById(Long id){
        FilmEntity film=filmRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Film","id",String.valueOf(id)));
        FilmDTO filmDTO= filmMapper.filmEntity2DTO(film,Boolean.TRUE);
        return filmDTO;
    }

    public FilmDTO update(FilmDTO filmDTO, Long id) {
        FilmEntity film=filmRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Film","id",String.valueOf(id)));
        filmMapper.FilmEntityRefreshValues(film,filmDTO);
        FilmEntity filmSaved=filmRepository.save(film);
        FilmDTO filmDTOSaved= filmMapper.filmEntity2DTO(filmSaved,Boolean.TRUE);
        return filmDTOSaved;
    }

    public void delete(Long id){
        FilmEntity film=filmRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Film","id",String.valueOf(id)));
        filmRepository.deleteById(id);
    }
}
