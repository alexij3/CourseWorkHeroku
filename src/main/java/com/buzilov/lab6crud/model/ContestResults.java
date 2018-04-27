package com.buzilov.lab6crud.model;

public class ContestResults {
    private ContestInPalace contest;
    private int contestId;
    private Artist artist;
    private int artistId;
    private int place;
    private char isWinner;

    public ContestResults() {
    }

    public ContestResults(int contestId, int artistId, int place, char isWinner) {
        this.contestId = contestId;
        this.artistId = artistId;
        this.place = place;
        this.isWinner = isWinner;
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

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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
