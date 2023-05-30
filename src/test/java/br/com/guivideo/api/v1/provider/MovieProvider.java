package br.com.guivideo.api.v1.provider;

import br.com.guivideo.api.v1.dto.response.MovieResponse;
import br.com.guivideo.business.entity.Movie;

public class MovieProvider {

    public static final Movie MOVIE_A = new Movie("Filme A");
    public static final Movie MOVIE_A_SALVO = new Movie(1L,"Filme A");
    public static final MovieResponse MOVIE_RESPONSE_A = new MovieResponse("Filme A");
    public static final String TITLE_MOVIE_A = MOVIE_RESPONSE_A.getTitle();

}
