package br.com.guivideo.api.v1.controller;

import br.com.guivideo.business.service.impl.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static br.com.guivideo.provider.MovieProvider.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    private final String URL = "/api/v1/movies";

    @Test
    @DisplayName("Deve realizar o registo de um filme com sucesso")
    void deveRegistarFilmeComSucesso() throws Exception {

        when(movieService.registerMovie(TITLE_MOVIE_A)).thenReturn(MOVIE_RESPONSE_A);

        mockMvc.perform(post(URL)
                        .queryParam("title", "213")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(TITLE_MOVIE_A));
    }

}
