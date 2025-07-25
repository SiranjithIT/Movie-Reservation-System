package com.rs.show_service.service;

import com.rs.show_service.dto.ShowDateDto;
import com.rs.show_service.model.Show;
import com.rs.show_service.model.TimeSlot;
import com.rs.show_service.repo.ShowRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class ShowService {
    @Autowired
    private ShowRepo showRepo;

    public String addDay(Show show){
        try{
            Optional<Show> existingShow = showRepo.findByDate(show.getDate());
            if (existingShow.isPresent()) {
                return "Show already exists for date: " + show.getDate();
            }

            List<TimeSlot> slots = new ArrayList<>();

            slots.addAll(
                    Arrays.asList(
                            new TimeSlot("06A", "06 am to 09 am"),
                            new TimeSlot("10A", "10 am to 01 pm"),
                            new TimeSlot("05P", "05 pm to 08 pm"),
                            new TimeSlot("09P", "09 pm to 12 pm")
                    )
            );

            show.setAvailableSlots(slots);
            show.setOccupiedSlots(new ArrayList<>());

            showRepo.save(show);
            return "Successfully day created for date: " + show.getDate();
        }
        catch (Exception e){
            return "Exception occurred in adding the date " + e.getMessage();
        }
    }

    public String addSlot(Long id, String slotKey, UUID movieId){
        try{
            Optional<Show> optionalShow = showRepo.findById(id);
            if (!optionalShow.isPresent()) {
                return "Show not found";
            }

            Show show = optionalShow.get();
            if (show.getAvailableSlots() == null) {
                show.setAvailableSlots(new ArrayList<>());
            }
            if (show.getOccupiedSlots() == null) {
                show.setOccupiedSlots(new ArrayList<>());
            }

            TimeSlot slotToBook = null;

            Iterator<TimeSlot> iterator = show.getAvailableSlots().iterator();
            while(iterator.hasNext()){
                TimeSlot slot = iterator.next();
                if(slot.getSlotKey().equals(slotKey)){
                    slotToBook = slot;
                    iterator.remove();
                    break;
                }
            }

            if(slotToBook != null){
                slotToBook.setMovieId(movieId);
                show.addOccupiedSlot(slotToBook);
                showRepo.save(show);
                return "Movie successfully added to the Slot: " + slotKey + " for movie: " + movieId;
            }
            else {
                return "Slot '" + slotKey + "' not available or already booked";
            }

        }
        catch (Exception e){
            return "Exception:0 " + e.getMessage();
        }
    }

    @Transactional(readOnly = true)
    public List<Show> getShows() {
        try {
            return showRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve shows: " + e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Optional<Show> getShowById(Long id) {
        return showRepo.findById(id);
    }

    public String cancelSlot(Long showId, String slotKey) {
        try {
            Optional<Show> optionalShow = showRepo.findById(showId);
            if (!optionalShow.isPresent()) {
                return "Show not found";
            }

            Show show = optionalShow.get();

            TimeSlot slotToCancel = null;
            Iterator<TimeSlot> iterator = show.getOccupiedSlots().iterator();
            while (iterator.hasNext()) {
                TimeSlot slot = iterator.next();
                if (slot.getSlotKey().equals(slotKey)) {
                    slotToCancel = slot;
                    iterator.remove();
                    break;
                }
            }

            if (slotToCancel != null) {
                slotToCancel.setMovieId(null);
                show.getAvailableSlots().add(slotToCancel);

                showRepo.save(show);
                return "Slot '" + slotKey + "' cancelled successfully";
            } else {
                return "Slot '" + slotKey + "' not found in booked slots";
            }
        } catch (Exception exception) {
            return "Exception occurred: " + exception.getMessage();
        }
    }

    @Transactional(readOnly = true)
    public List<TimeSlot> getAvailableSlots(Long showId) {
        Optional<Show> show = showRepo.findById(showId);
        if (show.isPresent()) {
            return show.get().getAvailableSlots();
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public List<TimeSlot> getOccupiedSlots(Long showId) {
        Optional<Show> show = showRepo.findById(showId);
        if (show.isPresent()) {
            return show.get().getOccupiedSlots();
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public Show getShowByDate(ShowDateDto date){
        Optional<Show> showOpt = showRepo.findByDate(date.getDate());
        if(showOpt.isPresent()){
            return showOpt.get();
        }
        throw new RuntimeException();
    }
}
