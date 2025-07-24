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
    private Long showId;

    @Column(nullable = false)
    private String slotKey;

    @Column(nullable = false)
    private String seatNum;

    @Column(nullable = false)
    private UUID userId;

    public Reservation() {
    }

    public Reservation(Long showId, String slotKey, UUID userId, String seatNum) {
        this.showId = showId;
        this.slotKey = slotKey;
        this.userId = userId;
        this.seatNum = seatNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
