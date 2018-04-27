package com.buzilov.lab6crud.model;

import java.time.LocalDate;

public class CinemaMovie {
    private int id;
    private String name;
    private Genre genre;
    private Cinema cinema;
    private int cinemaId;

    private LocalDate date;

    public CinemaMovie() {
    }

    public CinemaMovie(int id, String name, Genre genre, Cinema cinema, int cinemaId, LocalDate date) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.cinema = cinema;
        this.cinemaId = cinemaId;
        this.date = date;
    }

    public CinemaMovie(int id, String name, Genre genre, int cinemaId, LocalDate date) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.cinemaId = cinemaId;
        this.date = date;
    }

    public CinemaMovie(String name, Genre genre, LocalDate date) {
        this.name = name;
        this.genre = genre;
        if (date == null) {
            this.date = LocalDate.of(2018, 1, 1);
        }else this.date = date;
    }

    public CinemaMovie(String name, Genre genre, Cinema cinema, int cinemaId, LocalDate date) {
        this.name = name;
        this.genre = genre;
        this.cinema = cinema;
        this.cinemaId = cinemaId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CinemaMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", cinema=" + cinema +
                ", cinemaId=" + cinemaId +
                ", date=" + date +
                '}';
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
