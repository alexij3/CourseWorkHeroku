package com.buzilov.lab6crud.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TheatrePerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_theatre", insertable = false, updatable = false)
    private Theatre theatre;

    @Column(name = "id_theatre", nullable = false)
    private int theatreId;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_organizer", insertable = false, updatable = false)
    private Organizer organizer;

    @Column(name="id_organizer", nullable = false)
    private int organizerId;

    @Column
    private LocalDate date;

    public TheatrePerformance() {
    }

    public TheatrePerformance(int id, int theatreId, String name, int organizerId, LocalDate date) {
        this.id = id;
        this.theatreId = theatreId;
        this.name = name;
        this.organizerId = organizerId;
        this.date = date;
    }

    public TheatrePerformance(int id, String name, Theatre theatre, Organizer organizer, LocalDate date) {
        this.id = id;
        this.theatre = theatre;
        this.name = name;
        this.organizer = organizer;
        this.date = date;
    }

    @Override
    public String toString() {
        return "TheatrePerformance{" +
                "id=" + id +
                ", theatre=" + theatre +
                ", name='" + name + '\'' +
                ", organizer=" + organizer +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
