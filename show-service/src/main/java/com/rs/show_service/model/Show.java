package com.rs.show_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(nullable = false)
    private LocalDate date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "available_slots", joinColumns = @JoinColumn(name = "show_id"))
    private List<TimeSlot> availableSlots = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "occupied_slots", joinColumns = @JoinColumn(name = "show_id"))
    private List<TimeSlot> occupiedSlots = new ArrayList<>();

    public Show() {
    }

    public Show(Long uniqueId, LocalDate date, List<TimeSlot> availableSlots, List<TimeSlot> occupiedSlots) {
        this.uniqueId = uniqueId;
        this.date = date;
        this.availableSlots = availableSlots != null ? availableSlots : new ArrayList<>();
        this.occupiedSlots = occupiedSlots != null ? occupiedSlots : new ArrayList<>();
    }

    public Show( LocalDate date, List<TimeSlot> availableSlots, List<TimeSlot> occupiedSlots) {
        this.date = date;
        this.availableSlots = availableSlots != null ? availableSlots : new ArrayList<>();
        this.occupiedSlots = occupiedSlots != null ? occupiedSlots : new ArrayList<>();
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TimeSlot> getAvailableSlots() {
        if(availableSlots == null){
            availableSlots = new ArrayList<>();
        }
        return availableSlots;
    }

    public void setAvailableSlots(List<TimeSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<TimeSlot> getOccupiedSlots() {
        if(occupiedSlots == null){
            occupiedSlots = new ArrayList<>();
        }
        return occupiedSlots;
    }

    public void setOccupiedSlots(List<TimeSlot> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    public void removeSlot(TimeSlot slot){
        if(availableSlots != null){
            availableSlots.remove(slot);
        }
    }

    public void addOccupiedSlot(TimeSlot slot) {
        if (occupiedSlots == null) {
            occupiedSlots = new ArrayList<>();
        }
        occupiedSlots.add(slot);
    }


}
