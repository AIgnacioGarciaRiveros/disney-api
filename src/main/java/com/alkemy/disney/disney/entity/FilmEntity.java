package com.alkemy.disney.disney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="films")
//@Getter
//@Setter
@SQLDelete(sql = "UPDATE films SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String image;
    private String title;
    @Column(name="release_date")
    @DateTimeFormat(pattern="yyyy/MM/dd")
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
    @ManyToOne()
    @JoinColumn(name="id_genre")
    private GenreEntity genre;
   private boolean deleted = Boolean.FALSE;

    public FilmEntity() {
    }

    public FilmEntity(Long id, String image, String title, LocalDate releaseDate, Integer rate, List<CharacterEntity> characters, GenreEntity genre, boolean deleted) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.releaseDate = releaseDate;
        this.rate = rate;
        this.characters = characters;
        this.genre = genre;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
