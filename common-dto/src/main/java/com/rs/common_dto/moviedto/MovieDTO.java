package com.rs.common_dto.moviedto;

import java.util.List;
import java.util.UUID;

public class MovieDTO {
    private UUID id;
    private String title;
    private String description;
    private String image;
    private List<String> genre;

    public MovieDTO() {
    }

    public MovieDTO(UUID id, String title, String description, String image, List<String> genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.genre = genre;
    }

    public MovieDTO(String title, String description, String image, List<String> genre) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.genre = genre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
