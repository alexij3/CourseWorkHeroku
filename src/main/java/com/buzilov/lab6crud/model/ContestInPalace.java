package com.buzilov.lab6crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="contest_in_palace")
public class ContestInPalace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_palace", insertable = false, updatable = false)
    private CulturePalace culturePalace;

    @Column(name="id_palace", nullable = false)
    private int culturePalaceId;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_organizer", insertable = false, updatable = false)
    private Organizer organizer;

    @Column(name="id_organizer", nullable = false)
    private int organizerId;

    @Column
    private LocalDate date;

    @JsonIgnore
    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
    private Set<ContestResults> contestResults = new HashSet<>();

    public ContestInPalace() {
    }

    public ContestInPalace(Integer id, int culturePalaceId, String name, int organizerId, LocalDate date) {
        this.id = id;
        this.culturePalaceId = culturePalaceId;
        this.name = name;
        this.organizerId = organizerId;
        this.date = date;
    }

    public ContestInPalace(Integer id, CulturePalace culturePalace, String name, Organizer organizer, LocalDate date) {
        this.id = id;
        this.culturePalace = culturePalace;
        this.name = name;
        this.organizer = organizer;
        this.date = date;
    }



    public CulturePalace getCulturePalace() {
        return culturePalace;
    }

    public void setCulturePalace(CulturePalace culturePalace) {
        this.culturePalace = culturePalace;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCulturePalaceId() {
        return culturePalaceId;
    }

    public void setCulturePalaceId(int culturePalaceId) {
        this.culturePalaceId = culturePalaceId;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public Set<ContestResults> getContestResults() {
        return contestResults;
    }

    public void setContestResults(Set<ContestResults> contestResults) {
        this.contestResults = contestResults;
    }

    @Override
    public String toString() {
        return "ContestInPalace{" +
                "id=" + id +
                ", culturePalace=" + culturePalace +
                ", name='" + name + '\'' +
                ", organizer=" + organizer +
                ", date=" + date +
                '}';
    }
}
