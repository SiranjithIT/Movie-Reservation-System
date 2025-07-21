package com.rs.show_service.repo;


import com.rs.show_service.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepo extends JpaRepository<Show, Long> {
    Optional<Show> findByDate(LocalDate date);
    List<Show> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
