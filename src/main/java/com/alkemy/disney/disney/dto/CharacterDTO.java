package com.alkemy.disney.disney.dto;
import com.alkemy.disney.disney.entity.FilmEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//@Getter
//@Setter
public class CharacterDTO {
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private double weight;
    private String story;
    private List<FilmDTO> films;

    public CharacterDTO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<FilmDTO> getFilms() {
        return films;
    }

    public void setFilms(List<FilmDTO> films) {
        this.films = films;
    }
}
