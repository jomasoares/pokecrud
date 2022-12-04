package com.jomasoares.pokecrud.services;

import java.io.StringReader;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jomasoares.pokecrud.exceptions.BadRequestException;
import com.jomasoares.pokecrud.exceptions.NotFoundException;
import com.jomasoares.pokecrud.mappers.PokemonMapper;
import com.jomasoares.pokecrud.models.Pokemon;
import com.jomasoares.pokecrud.repositories.PokemonRepository;

@Service
public class PokemonService {

    @Value("${api.url}")
    private String apiUrl;
    
    private PokemonRepository pokemonRepository;

    private RestTemplate restTemplate;

    public PokemonService(PokemonRepository pokemonRepository, RestTemplate restTemplate) {
        this.pokemonRepository = pokemonRepository;
        this.restTemplate = restTemplate;
    }

    public Pokemon get(Integer id) {
        Optional<Pokemon> p = pokemonRepository.findById(id);
        if(p.isPresent()) return p.get();

        p = getFromApi(id);
        if(p.isPresent()) {
            pokemonRepository.save(p.get());
            return p.get();
        }
        
        throw new NotFoundException("Pokemon not found.");
    }

    public Pokemon save(Pokemon p) {
        if(pokemonRepository.findById(p.getId()).isPresent())
            throw new BadRequestException("Pokemon already exists with this id.");

        return pokemonRepository.save(p);
    }

    public Pokemon update(Pokemon p) {
        if(pokemonRepository.findById(p.getId()).isEmpty())
            throw new BadRequestException("No pokemon found with this id.");

        return pokemonRepository.save(p);
    }

    public void delete(Integer id) {
        pokemonRepository.deleteById(id);
    }
    
    private Optional<Pokemon> getFromApi(Integer id) {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl + id, String.class);
        //TODO tratar isso aqui. retornar vazio somente com status code 404.
        JsonObject responseBody = Json.createReader(new StringReader(response.getBody())).readObject();
        if(response.getStatusCode() != HttpStatus.OK)
            return Optional.empty();
        
        return Optional.of(PokemonMapper.toModel(responseBody));
    }
}
