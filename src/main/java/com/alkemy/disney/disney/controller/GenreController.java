package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;
//todo: xq llama a un servicio interfaz y no a la implementacion , funciona ?
    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDto)
    {
        //save dto
        GenreDTO newGenre= genreService.save(genreDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newGenre);
    }
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll()
    {
        List<GenreDTO> genres=genreService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }



}
