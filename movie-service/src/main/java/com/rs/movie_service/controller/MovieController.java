package com.rs.movie_service.controller;

import com.rs.common_dto.moviedto.MovieDTO;
import com.rs.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
