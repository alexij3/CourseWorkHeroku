package com.buzilov.lab6crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CinemaMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cinema", nullable = false, insertable = false, updatable = false)
    private Cinema cinema;

    @Column(name = "id_cinema", nullable = false)
    private int cinemaId;

    @Column
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
