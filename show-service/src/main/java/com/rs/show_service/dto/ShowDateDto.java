package com.rs.show_service.dto;

import java.time.LocalDate;

public class ShowDateDto {
    LocalDate date;

    public ShowDateDto() {
    }

    public ShowDateDto(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
