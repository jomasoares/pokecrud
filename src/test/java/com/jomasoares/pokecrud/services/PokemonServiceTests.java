package com.jomasoares.pokecrud.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.jomasoares.pokecrud.exceptions.NotFoundException;
import com.jomasoares.pokecrud.models.Pokemon;
import com.jomasoares.pokecrud.repositories.PokemonRepository;

@SpringBootTest
@SpringBootConfiguration
@TestInstance(Lifecycle.PER_CLASS)
public class PokemonServiceTests {

    @Value("${api.url}")
    private String apiUrl;
    
    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;

    private Pokemon exemple = Pokemon.builder()
                                .id(1)
                                .name("pikachu")
                                .height(1)
                                .weight(1)
                                .build();


    @BeforeAll
    public void setUp(){
        ReflectionTestUtils.setField(pokemonService, "apiUrl", "https://pokeapi.co/api/v2/pokemon/");
    }
    
    @Test
    void listAllPokemonsNotEmpty() {
        //given
        List<Pokemon> storedList = new ArrayList<>();
        storedList.add(exemple);

        //when
        when(pokemonRepository.findAll()).thenReturn(storedList);

        //then
        List<Pokemon> foundList = pokemonService.getAll();
        assertEquals(storedList.size(), foundList.size());
        assertEquals(storedList.get(0), foundList.get(0));
    }

    @Test
    void listAllPokemonsEmpty() {
        //given
        List<Pokemon> storedList = new ArrayList<>();

        //when
        when(pokemonRepository.findAll()).thenReturn(storedList);

        //then
        List<Pokemon> foundList = pokemonService.getAll();
        assertEquals(storedList.size(), foundList.size());
        assertEquals(0, foundList.size());
    }

    @Test
    void getValidPokemon() {
        Integer validId = 2;
        assertNotNull(pokemonService.get(validId));
    }

    @Test
    void getNotValidPokemon() {
        Integer invalidId = 83294789;

        assertThrows(NotFoundException.class, () -> pokemonService.get(invalidId));
    }
}
