package com.buzilov.lab6crud.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ContestResultsID.class)
@Table(name="contest_results")
public class ContestResults implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_contest", insertable = false, updatable = false)
    private ContestInPalace contest;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_artist", insertable = false, updatable = false)
    private Artist artist;

    @Column
    private int place;

    @Column(name="is_winner")
    private char isWinner;

    public ContestResults() {
    }


    public ContestResults(ContestInPalace contest, Artist artist, int place, char isWinner) {
        this.contest = contest;
        this.artist = artist;
        this.place = place;
        this.isWinner = isWinner;
    }

    public ContestInPalace getContest() {
        return contest;
    }

    public void setContest(ContestInPalace contest) {
        this.contest = contest;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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

    public void setIsWinner(char isWinner) {
        this.isWinner = isWinner;
    }

    @Override
    public String toString() {
        return "ContestResults{" +
                "contest=" + contest +
                ", artist=" + artist +
                ", place=" + place +
                ", isWinner=" + isWinner +
                '}';
    }
}
