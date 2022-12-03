package com.jomasoares.pokecrud.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Base pokemon representation.
 */
@Data
@AllArgsConstructor
@Builder
public class Pokemon {

    private Integer id;

    private String name;

    private Integer height;
    
    private Integer weight;

    private List<String> types;
}
