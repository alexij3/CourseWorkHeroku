package com.buzilov.lab6crud.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="contest_results")
@IdClass(ContestResultsID.class)
public class ContestResults implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_contest")
    private ContestInPalace contest;

    @Column
    private int place;

    @Column(name="is_winner")
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
