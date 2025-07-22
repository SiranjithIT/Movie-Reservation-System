package com.rs.reservation_service.service;

import com.rs.reservation_service.model.Reservation;
import com.rs.reservation_service.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    public List<Reservation> getReservations(){
        return reservationRepo.findAll();
    }

    public String addReservation(Reservation reservation){
        try{
            reservationRepo.save(reservation);
            return "Ticket is reserved for the user : " + reservation.getUserId();
        }
        catch (Exception exc){
            return "Exception occurred : " + exc.getMessage();
        }
    }

    public String deleteReservation(UUID id){
        try{
            reservationRepo.deleteById(id);
            return "Deleted successfully";
        }
        catch (Exception exc){
            return "Exception occurred: " + exc.getMessage();
        }
    }
}
