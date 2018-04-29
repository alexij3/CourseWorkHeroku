package com.buzilov.lab6crud.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private int screenSize;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CinemaMovie> cinemaMovies;

    public Cinema() {
    }

    public Cinema(String name, String address, int screenSize) {
        this.name = name;
        this.address = address;
        this.screenSize = screenSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public List<CinemaMovie> getCinemaMovies() {
        return cinemaMovies;
    }

    public void setCinemaMovies(List<CinemaMovie> cinemaMovies) {
        this.cinemaMovies = cinemaMovies;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
