package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.FilmDTO;
import com.alkemy.disney.disney.entity.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmMapper {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private GenreMapper genreMapper;
    public FilmDTO filmEntity2DTO(FilmEntity film,boolean loadCharacters){
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setId(film.getId());
        filmDTO.setImage(film.getImage());
        filmDTO.setTitle(film.getTitle());
        filmDTO.setReleaseDate(film.getReleaseDate());
        filmDTO.setRate(film.getRate());
        if(loadCharacters){
        List<CharacterDTO> charactersDTO = characterMapper.characterEntityList2DTOList(film.getCharacters(),false);
            filmDTO.setCharacters(charactersDTO);
        }
        //TODO:Preguntar si tambien mando un boolean para el genero
        filmDTO.setGenre(genreMapper.genreEntity2DTO(film.getGenre()));
        return filmDTO;
    }
//TODO:DTOLIST TO ENTITY LIST AND VICEVERSA
//TODO: VERIFY BOOLEAN VALUE IN LIST
    public FilmEntity filmDTO2Entity(FilmDTO filmDTO){
        FilmEntity film = new FilmEntity();
        film.setId(film.getId());
        film.setImage(filmDTO.getImage());
        film.setTitle(filmDTO.getTitle());
        film.setReleaseDate(filmDTO.getReleaseDate());
        film.setRate(filmDTO.getRate());
       // film.setCharacters(filmDTO.getCharacters());
       // film.setGenre(filmDTO.getGenre());
        return film;
    }
    public List<FilmDTO>filmEntityList2DTOList(List<FilmEntity> films,boolean loadCharacters){
        List<FilmDTO>filmsDTOs=new ArrayList<>();
        for (FilmEntity film: films) {
            filmsDTOs.add(filmEntity2DTO(film,loadCharacters));
        }
        return filmsDTOs;
    }

    public List<FilmEntity>filmDTOList2EntityList(List<FilmDTO> filmsDTO){
        List<FilmEntity>films=new ArrayList<>();
        for (FilmDTO filmDTO:
                filmsDTO) {
            films.add(filmDTO2Entity(filmDTO));
        }
        return films;
    }

    public void FilmEntityRefreshValues(FilmEntity film,FilmDTO filmDTO){
        film.setImage(filmDTO.getImage());
        film.setRate(filmDTO.getRate());
        film.setTitle(filmDTO.getTitle());
        film.setReleaseDate(filmDTO.getReleaseDate());
    }

//refrescar valores , recibe entidad y dto
}
