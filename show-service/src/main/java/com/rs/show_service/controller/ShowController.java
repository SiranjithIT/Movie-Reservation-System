package com.rs.show_service.controller;


import com.rs.show_service.dto.BookSlotRequest;
import com.rs.show_service.dto.ShowDateDto;
import com.rs.show_service.dto.ShowRequest;
import com.rs.show_service.model.Show;
import com.rs.show_service.model.TimeSlot;
import com.rs.show_service.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
@CrossOrigin(origins = "http://localhost:4200")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public ResponseEntity<List<Show>> getShows() {
        try {
            List<Show> shows = showService.getShows();
            return ResponseEntity.ok(shows);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/date")
    public ResponseEntity<Show> getShowByDate(@RequestBody ShowDateDto date){
        try{
            Show show = showService.getShowByDate(date);
            return ResponseEntity.ok(show);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addShow(@RequestBody ShowRequest showRequest) {
        Show show = new Show();
        show.setDate(showRequest.getDate());
        String result = showService.addDay(show);

        if (result.contains("Exception") || result.contains("already exists")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/book-slot")
    public ResponseEntity<String> bookSlot(@RequestBody BookSlotRequest request) {
        String result = showService.addSlot(request.getShowId(), request.getSlotKey(), request.getMovieId());

        if (result.contains("Exception") || result.contains("not found") || result.contains("not available")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Optional<Show> show = showService.getShowById(id);
        if (show.isPresent()) {
            return ResponseEntity.ok(show.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{showId}/cancel-slot/{slotKey}")
    public ResponseEntity<String> cancelSlot(@PathVariable Long showId, @PathVariable String slotKey) {
        String result = showService.cancelSlot(showId, slotKey);

        if (result.contains("Exception") || result.contains("not found")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{showId}/available-slots")
    public ResponseEntity<List<TimeSlot>> getAvailableSlots(@PathVariable Long showId) {
        List<TimeSlot> availableSlots = showService.getAvailableSlots(showId);
        return ResponseEntity.ok(availableSlots);
    }

    @GetMapping("/{showId}/occupied-slots")
    public ResponseEntity<List<TimeSlot>> getOccupiedSlots(@PathVariable Long showId) {
        List<TimeSlot> occupiedSlots = showService.getOccupiedSlots(showId);
        return ResponseEntity.ok(occupiedSlots);
    }
}
