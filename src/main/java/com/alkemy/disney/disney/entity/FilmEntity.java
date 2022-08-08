package com.alkemy.disney.disney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String image;
    private String title;
    @Column(name="release_date")
    private LocalDate releaseDate;
    private Integer rate;
    @JoinTable(
            name="rel_character_film",
            joinColumns = @JoinColumn(name="id_film",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_character",nullable = false)
    )
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    } )
    private List<CharacterEntity> characters;
    @ManyToOne (cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name="id_genre",insertable = false,updatable = false)
    private GenreEntity genre;



}
