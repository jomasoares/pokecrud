package com.jomasoares.pokecrud.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.json.JsonObject;

import com.jomasoares.pokecrud.dtos.PokemonRequestDto;
import com.jomasoares.pokecrud.dtos.PokemonResponseDto;
import com.jomasoares.pokecrud.models.Pokemon;

public class PokemonMapper {

    private PokemonMapper() {}
    
    public static Pokemon toModel(PokemonRequestDto dto) {
        if (dto == null) return null;
        return Pokemon.builder()
            .id(dto.getId())
            .name(dto.getName())
            .height(dto.getHeight())
            .weight(dto.getWeight())
            .build();
    }

    public static PokemonResponseDto toResponseDto(Pokemon model) {
        if (model == null) return null;
        return PokemonResponseDto.builder()
            .id(model.getId())
            .name(model.getName())
            .height(model.getHeight())
            .weight(model.getWeight())
            .build();
    }

    public static Pokemon toModel(JsonObject jo) {
        return Pokemon.builder()
            .id(jo.getInt("id"))
            .name(jo.getString("name"))
            .weight(jo.getInt("weight"))
            .height(jo.getInt("height"))
            .build();
    }

    public static List<PokemonResponseDto> toDtoList(List<Pokemon> list) {
        return list.stream().map(PokemonMapper::toResponseDto).collect(Collectors.toList());
    }
}
