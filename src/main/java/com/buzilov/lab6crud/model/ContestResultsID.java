package com.buzilov.lab6crud.model;

import java.io.Serializable;

public class ContestResultsID implements Serializable {
    private Artist artist;
    private ContestInPalace contest;

    public ContestResultsID() {
    }

    public ContestResultsID(Artist artist, ContestInPalace contest) {
        this.artist = artist;
        this.contest = contest;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContestResultsID that = (ContestResultsID) o;

        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        return contest != null ? contest.equals(that.contest) : that.contest == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (contest != null ? contest.hashCode() : 0);
        return result;
    }
}
