package com.jomasoares.pokecrud.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.jomasoares.pokecrud.models.Pokemon;
import com.jomasoares.pokecrud.services.PokemonService;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    private Pokemon exemple = Pokemon.builder()
                                .id(1)
                                .name("pikachu")
                                .height(1)
                                .weight(1)
                                .build();

    @Test
    public void listAllPokemonEndpoint() throws Exception {

        List<Pokemon> expectedList = new ArrayList<>();
        expectedList.add(exemple);

        when(pokemonService.getAll()).thenReturn(expectedList);
        this.mockMvc.perform(get("/pokemon"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("[{\"id\":1,\"name\":\"pikachu\",\"height\":1,\"weight\":1}]"));
    }
    
}
