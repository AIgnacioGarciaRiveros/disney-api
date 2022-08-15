package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.FilmDTO;
import com.alkemy.disney.disney.entity.FilmEntity;
import com.alkemy.disney.disney.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
//TODO:TERMINAR CONTROLLER
    @Autowired
    private FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmDTO> save(@RequestBody FilmDTO filmDTO){
        return new ResponseEntity<>(filmService.save(filmDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll(){
        List<FilmDTO>films=filmService.getAll();
        return  ResponseEntity.ok().body(films);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO>update(@RequestBody FilmDTO filmDTO,@PathVariable Long id) throws Exception {
        FilmDTO filmDTOSaved=filmService.update(filmDTO,id);
        return new ResponseEntity(filmDTOSaved, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete (@PathVariable Long id) throws Exception {
        filmService.delete(id);
        return new ResponseEntity<String>("Film deleted successfully",HttpStatus.OK);
    }

}
