package br.com.guivideo.api.v1.controller;

import br.com.guivideo.api.v1.dto.response.MovieResponse;
import br.com.guivideo.business.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    private final IMovieService movieService;
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> registerMovie(@RequestParam("title") String title){
        MovieResponse movieResponse = movieService.registerMovie(title);
        return new ResponseEntity<>(movieResponse, HttpStatus.CREATED);
    }
}
