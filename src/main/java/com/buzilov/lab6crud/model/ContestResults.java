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
    @JoinColumn(name="artist_id")
    @NotNull
    private Artist artist;

    @Column(name="artist_id", insertable = false, updatable = false)
    private int artist_id;

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

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
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
