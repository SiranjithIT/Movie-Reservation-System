package com.rs.reservation_service.repo;

import com.rs.reservation_service.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, UUID> {

}
