package com.rs.user_service.dto;

import com.rs.user_service.model.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String firstName;
    private String userName;
    private Gender gender;

    public UserDto(UUID id, String firstName, String userName, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.userName = userName;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
