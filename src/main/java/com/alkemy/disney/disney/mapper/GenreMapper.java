package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreDTO genreEntity2DTO(GenreEntity genre)
    {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setImage(genre.getImage());
        return genreDTO;
    }
//TODO: PREGUNTAR AL PROFE PORQUE NO VA EL ID EN GENREDTO2ENTITY
// ,ES X EL GENERATE SEQUENCE?
    public GenreEntity genreDTO2Entity(GenreDTO genreDTO)
    {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(genreDTO.getName());
        genreEntity.setImage(genreDTO.getImage());
        return genreEntity;
    }
    //TODO: preguntar nombre genresDTO O genresDTOList
    public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity>genreEntityList)
    {
        List<GenreDTO> genresDTO=new ArrayList<>();
        for (GenreEntity genre:
             genreEntityList) {
            genresDTO.add(genreEntity2DTO(genre));
        }
        return genresDTO;
    }


}
