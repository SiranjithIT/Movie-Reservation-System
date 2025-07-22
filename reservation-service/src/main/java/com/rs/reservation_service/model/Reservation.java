package com.rs.reservation_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String slotKey;

    @Column(nullable = false)
    private UUID userId;

    public Reservation() {
    }

    public Reservation(LocalDate date, String slotKey, UUID userId) {
        this.date = date;
        this.slotKey = slotKey;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSlotKey() {
        return slotKey;
    }

    public void setSlotKey(String slotKey) {
        this.slotKey = slotKey;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
