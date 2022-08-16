package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CharacterFilterDTO {
    private String name;
    private Integer age;
    private List<Long> films;
    //TODO:pongo el peso ??

    public CharacterFilterDTO(String name, Integer age, List<Long> films) {
        this.name = name;
        this.age = age;
        this.films = films;
    }
}
