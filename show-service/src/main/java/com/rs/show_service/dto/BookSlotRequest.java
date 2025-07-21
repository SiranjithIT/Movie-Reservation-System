package com.rs.show_service.dto;

import lombok.Data;
import java.util.UUID;


public class BookSlotRequest {
    private Long showId;
    private String slotKey;
    private UUID movieId;

    public BookSlotRequest() {}

    public BookSlotRequest(Long showId, String slotKey, UUID movieId) {
        this.showId = showId;
        this.slotKey = slotKey;
        this.movieId = movieId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getSlotKey() {
        return slotKey;
    }

    public void setSlotKey(String slotKey) {
        this.slotKey = slotKey;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public void setMovieId(UUID movieId) {
        this.movieId = movieId;
    }
}
