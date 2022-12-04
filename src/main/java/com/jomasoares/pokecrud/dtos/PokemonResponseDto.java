package com.jomasoares.pokecrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Dto for pokemon body responses.
 */
@Data
@AllArgsConstructor
@Builder
public class PokemonResponseDto {

    private Integer id;

    private String name;

    private Integer height;
    
    private Integer weight;
    
}
