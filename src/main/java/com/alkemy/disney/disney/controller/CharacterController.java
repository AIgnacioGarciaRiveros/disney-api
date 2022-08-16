package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
//TODO: inyeccion x autowired vs inyeccion x constructor
//TODO: preguntar updateCharacter o solo Update ?

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO characterDTO){
       return new ResponseEntity<>(characterService.save(characterDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>>getAll() throws Exception {
        List<CharacterDTO> characters=characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO>getById(@PathVariable Long id) throws Exception {
        CharacterDTO character=characterService.getCharacterById(id);
        return ResponseEntity.ok().body(character);
    }
    @GetMapping
    public ResponseEntity<List<CharacterDTO>>getDetailsByFilters(
            @RequestParam(required = false) String name
            ,@RequestParam(required = false) Integer age
            ,@RequestParam(required = false) List<Long>films
    ){
        List<CharacterDTO>characterDTOList = characterService.getCharacterByFilters(name,age,films);
        return ResponseEntity.ok(characterDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id,@RequestBody CharacterDTO characterDTO) throws Exception {
        CharacterDTO characterDTOSaved=characterService.updateCharacter(characterDTO,id);
        return new ResponseEntity(characterDTOSaved,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable Long id) throws Exception {
        characterService.deleteCharacterById(id);
        return new ResponseEntity<>("Character entity deleted successfully", HttpStatus.OK);
    }



}


