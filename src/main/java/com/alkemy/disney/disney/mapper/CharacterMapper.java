package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.FilmDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    private FilmMapper filmMapper;
    public CharacterDTO characterEntity2DTO(CharacterEntity character,boolean loadFilms)
    {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(character.getId());
        characterDTO.setName(character.getName());
        characterDTO.setAge(character.getAge());
        characterDTO.setImage(character.getImage());
        characterDTO.setStory(character.getStory());
        characterDTO.setWeight(character.getWeight());
        if(loadFilms)
        {
            List<FilmDTO>filmsDTO=filmMapper.filmEntityList2DTOList(character.getFilms(),false);
            characterDTO.setFilms(filmsDTO);
        }
        //TODO:PREGUNTAR LISTA
        return characterDTO;
    }

    public CharacterEntity characterDTO2Entity(CharacterDTO characterDTO)
    {
        CharacterEntity character = new CharacterEntity();
        character.setName(characterDTO.getName());
        character.setImage(characterDTO.getImage());
        character.setStory(characterDTO.getStory());
        character.setWeight(characterDTO.getWeight());
        character.setAge(characterDTO.getAge());
       // character.setFilms(characterDTO.getFilms());
        return character;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characters,boolean loadFilms){
        List<CharacterDTO>characterDTOList = new ArrayList<>();
        for (CharacterEntity character: characters) {
            characterDTOList.add(characterEntity2DTO(character,loadFilms));
        }
        return characterDTOList;
    }
    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> charactersDTO){
        List<CharacterEntity>characters = new ArrayList<>();
        for (CharacterDTO characterDTO: charactersDTO) {
            characters.add(characterDTO2Entity(characterDTO));
        }
        return characters;
    }

    public void CharacterEntityRefreshValues(CharacterEntity character,CharacterDTO characterDTO){
        character.setStory(characterDTO.getStory());
        character.setName(characterDTO.getName());
        character.setWeight(characterDTO.getWeight());
        character.setImage(characterDTO.getImage());
        character.setAge(characterDTO.getAge());
    }




}
