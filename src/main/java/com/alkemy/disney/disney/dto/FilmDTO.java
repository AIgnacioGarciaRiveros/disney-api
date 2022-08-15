package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.CharacterEntity;
import com.alkemy.disney.disney.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class FilmDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate releaseDate;
    private Integer rate;
    private List<CharacterDTO> characters;
    private GenreDTO genre;
    //private GenreEntity genre;
    //TODO:GenreDTO o GenreEntity ??

}
