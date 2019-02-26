package com.detroitlabs.giflibrary.model;

import java.time.LocalDate;

public class Gif {

    private String name;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;
    private int id;

    public Gif(String name, LocalDate dateUploaded, String username, boolean favorite, int id) {
        this.name = name;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.favorite = favorite;
        this.id = id;
    }

    public String getUploaderImageURL(){
        return username.replace(" ", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
