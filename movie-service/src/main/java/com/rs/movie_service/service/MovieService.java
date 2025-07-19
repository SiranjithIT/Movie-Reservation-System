package com.rs.movie_service.service;

import com.rs.common_dto.moviedto.MovieDTO;
import com.rs.movie_service.model.Movie;
import com.rs.movie_service.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    private MovieDTO convertToDTO(Movie entity){
        return new MovieDTO(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getImage(), entity.getGenre());
    }

    public List<MovieDTO> getMovies(){
        return movieRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO getMovie(UUID id){
        return movieRepo.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public String addMovie(MovieDTO movie){
        try{
            Movie newMovie = new Movie();
            newMovie.setTitle(movie.getTitle());
            newMovie.setDescription(movie.getDescription());
            newMovie.setImage(movie.getImage());
            newMovie.setGenre(movie.getGenre());
            movieRepo.save(newMovie);
            return "Movie added successfully";
        }
        catch (Exception e){
            return "Unable to add movie "+e;
        }
    }


}
