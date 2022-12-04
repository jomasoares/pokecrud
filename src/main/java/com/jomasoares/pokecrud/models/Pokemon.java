package com.jomasoares.pokecrud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Basic pokemon representation.
 */
@Data
@AllArgsConstructor
@Builder
@Entity
public class Pokemon {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer height;
    
    @Column(nullable = false)
    private Integer weight;
}
