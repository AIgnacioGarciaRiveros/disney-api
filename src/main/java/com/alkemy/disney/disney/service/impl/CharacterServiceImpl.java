package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.CharacterFilterDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;
import com.alkemy.disney.disney.exception.ResourceNotFoundException;
import com.alkemy.disney.disney.mapper.CharacterMapper;
import com.alkemy.disney.disney.repository.CharacterRepository;
import com.alkemy.disney.disney.repository.specifications.CharacterSpecification;
import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private  CharacterSpecification characterSpecification;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;

    public CharacterDTO save(CharacterDTO characterDTO) {
        CharacterEntity character= characterMapper.characterDTO2Entity(characterDTO);
        CharacterEntity characterSaved = characterRepository.save(character);
        CharacterDTO characterDTO1 = characterMapper.characterEntity2DTO(characterSaved,Boolean.FALSE);
        return characterDTO1;
    }

    public List<CharacterDTO> getAllCharacters(){
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterDTO>charactersDTOs=characterMapper.characterEntityList2DTOList(characters,Boolean.FALSE);
        return charactersDTOs;
    }

    public CharacterDTO getCharacterById(long id){
            CharacterEntity character=characterRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Character","id",String.valueOf(id)));
        CharacterDTO characterDTO=characterMapper.characterEntity2DTO(character,Boolean.FALSE);
        return characterDTO;
    }

    public List<CharacterDTO> getCharacterByFilters(String name, Integer age, List<Long> films) {
        CharacterFilterDTO filterDTO=new CharacterFilterDTO(name,age,films);
        List<CharacterEntity> charactersFiltered=characterRepository.findAll(characterSpecification.getByFilters(filterDTO));
        List<CharacterDTO> characterDTOList = characterMapper.characterEntityList2DTOList(charactersFiltered,false);
        return characterDTOList;
    }

    public CharacterDTO updateCharacter(CharacterDTO characterDTO, long id){
        CharacterEntity character = characterRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Character","id",String.valueOf(id)));
        characterMapper.CharacterEntityRefreshValues(character,characterDTO);
        CharacterEntity  newCharacter = characterRepository.save(character);
        CharacterDTO characterDTO1= characterMapper.characterEntity2DTO(newCharacter,Boolean.FALSE);
        return characterDTO1;
    }

    public void deleteCharacterById(long id) {
        CharacterEntity character = characterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Character","id",String.valueOf(id)));
        characterRepository.deleteById(id);
    }

}
