package com.rs.show_service.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TimeSlot {
    @Column(name = "slot_key")
    private String slotKey;

    @Column(name = "complete_time")
    private String completeTime;

    @Column(name = "movie_id")
    private UUID movieId;

    public TimeSlot(String slotKey, String completeTime, UUID movieId) {
        this.slotKey = slotKey;
        this.completeTime = completeTime;
        this.movieId = movieId;
    }

    public TimeSlot(String slotKey, String completeTime) {
        this.slotKey = slotKey;
        this.completeTime = completeTime;
        this.movieId = null;
    }

    public TimeSlot() {
    }

    public String getSlotKey() {
        return slotKey;
    }

    public void setSlotKey(String slotKey) {
        this.slotKey = slotKey;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public void setMovieId(UUID movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(slotKey, timeSlot.slotKey) &&
                Objects.equals(completeTime, timeSlot.completeTime) &&
                Objects.equals(movieId, timeSlot.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotKey, completeTime, movieId);
    }

    @Override
    public String toString() {
        return "TimeMovie{" +
                "key='" + slotKey + '\'' +
                ", completeTime='" + completeTime + '\'' +
                ", movieId=" + movieId +
                '}';
    }
}
