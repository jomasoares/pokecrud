package com.jomasoares.pokecrud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jomasoares.pokecrud.dtos.PokemonRequestDto;
import com.jomasoares.pokecrud.dtos.PokemonResponseDto;
import com.jomasoares.pokecrud.mappers.PokemonMapper;
import com.jomasoares.pokecrud.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping()
    public List<PokemonResponseDto> getAll() {
        return PokemonMapper.toDtoList(pokemonService.getAll());
    }
    
    @GetMapping("/{id}")
    public PokemonResponseDto get(@PathVariable("id") Integer id) {
        return PokemonMapper.toResponseDto(pokemonService.get(id));
    }

    @PostMapping()
    public PokemonResponseDto post(@RequestBody PokemonRequestDto dto) {
        return PokemonMapper.toResponseDto(pokemonService.save(PokemonMapper.toModel(dto)));
    }

    @PutMapping("/{id}")
    public PokemonResponseDto update(@RequestBody PokemonRequestDto dto, @PathVariable("id") Integer id) {
        return PokemonMapper.toResponseDto(pokemonService.update(PokemonMapper.toModel(dto), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        pokemonService.delete(id);
    }

}
