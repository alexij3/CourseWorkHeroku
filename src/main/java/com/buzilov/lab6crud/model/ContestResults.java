package com.buzilov.lab6crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="contest_results")
public class ContestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @NotNull
    private Artist artist;

    @ManyToOne
    @NotNull
    private ContestInPalace contest;

    @Column
    @NotNull
    private int place;

    @Column(name="is_winner")
    @NotNull
    private char isWinner;

    public ContestResults() {
    }

    public ContestResults(int place, char isWinner) {
        this.place = place;
        this.isWinner = isWinner;
    }

    public ContestResults(Artist artist, ContestInPalace contest, int place, char isWinner) {
        this.artist = artist;
        this.contest = contest;
        this.place = place;
        this.isWinner = isWinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public char getIsWinner() {
        return isWinner;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        System.out.println(artist);
        this.artist = artist;
    }

    public ContestInPalace getContest() {
        return contest;
    }

    public void setContest(ContestInPalace contest) {
        this.contest = contest;
    }

    public void setIsWinner(char isWinner) {
        this.isWinner = isWinner;
    }


}
