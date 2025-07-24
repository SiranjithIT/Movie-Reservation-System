package com.rs.reservation_service.controller;

import com.rs.reservation_service.model.Reservation;
import com.rs.reservation_service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        try{
            List<Reservation> reservations = service.getReservations();
            return ResponseEntity.ok(reservations);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addReservation(@RequestBody Reservation reservation){
        String result = service.addReservation(reservation);
        if(result.contains("Exception")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable UUID id){
        String result = service.deleteReservation(id);
        if(result.contains("Exception")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Reservation> getReservationByShowId(@PathVariable Long id){
        try{
            Reservation reservation = service.getReservationByShowId(id);
            return ResponseEntity.ok(reservation);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
