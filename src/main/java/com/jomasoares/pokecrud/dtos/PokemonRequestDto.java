package com.jomasoares.pokecrud.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PokemonRequestDto {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 250)
    private String name;

    @Min(0)
    private Integer height;
    
    @Min(0)
    private Integer weight;
    
}
