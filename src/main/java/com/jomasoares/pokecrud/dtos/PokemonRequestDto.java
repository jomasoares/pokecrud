package com.jomasoares.pokecrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PokemonRequestDto {

    private Integer id;

    private String name;

    private Integer height;
    
    private Integer weight;
    
}
