package br.com.guivideo.business.service;

import br.com.guivideo.api.v1.dto.response.MovieResponse;
import br.com.guivideo.business.entity.Movie;
import br.com.guivideo.business.service.impl.MovieService;
import br.com.guivideo.infrastructure.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static br.com.guivideo.provider.MovieProvider.*;

@WebMvcTest(MovieService.class)
public class MovieServiceTest {

    @MockBean
    private MovieRepository movieRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("Deve salvar um filme corretamente")
    void deveSalvarUmFilmeComSucesso() {
        MovieResponse resultadoEsperado = MOVIE_RESPONSE_A;
        when(movieRepository.save(MOVIE_A)).thenReturn(MOVIE_A_SALVO);
        when(modelMapper.map(any(Movie.class), eq(MovieResponse.class))).thenReturn(MOVIE_RESPONSE_A);

        MovieResponse resultadoObtido = movieService.registerMovie(TITLE_MOVIE_A);

        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
        verify(movieRepository).save(MOVIE_A);
    }
}
