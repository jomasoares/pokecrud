package com.jomasoares.pokecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jomasoares.pokecrud.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{
    
}
