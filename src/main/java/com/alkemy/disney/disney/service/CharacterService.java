package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.FilmDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO characterDTO);
    List<CharacterDTO> getAllCharacters() throws Exception;
    CharacterDTO getCharacterById(long id) throws Exception;
    List<CharacterDTO> getCharacterByFilters(String name, Integer age, List<Long> films);
    CharacterDTO updateCharacter(CharacterDTO characterDTO,long id) throws Exception;
    void deleteCharacterById(long id) throws Exception;
}
