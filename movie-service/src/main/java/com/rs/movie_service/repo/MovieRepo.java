package com.rs.movie_service.repo;

import com.rs.movie_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepo extends JpaRepository<Movie, UUID> {
}
