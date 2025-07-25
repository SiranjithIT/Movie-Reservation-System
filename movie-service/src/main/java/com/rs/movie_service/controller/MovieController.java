package com.rs.movie_service.controller;

import com.rs.common_dto.moviedto.MovieDTO;
import com.rs.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<MovieDTO> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("/movies")
    public String addMovie(@RequestBody MovieDTO movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("/movies/{id}")
    public MovieDTO getMovie(@PathVariable("id") UUID id){
        return movieService.getMovieById(id);
    }
}
