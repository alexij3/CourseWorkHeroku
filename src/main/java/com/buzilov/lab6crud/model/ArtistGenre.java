package com.buzilov.lab6crud.model;

public class ArtistGenre {
    private Artist artist;
    private int artistId;
    private Genre genre;

    public ArtistGenre() {
    }

    public ArtistGenre(int artistId, Genre genre) {
        this.artistId = artistId;
        this.genre = genre;
    }

    public ArtistGenre(Artist artist) {
        this.artist = artist;
    }

    public ArtistGenre(Artist artist, Genre genre) {
        this.artist = artist;
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "ArtistGenre{" +
                "artist=" + artist +
                ", genre=" + genre +
                '}';
    }
}
