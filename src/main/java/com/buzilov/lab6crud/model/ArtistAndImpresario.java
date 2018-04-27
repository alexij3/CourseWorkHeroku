package com.buzilov.lab6crud.model;

public class ArtistAndImpresario {
    private Artist artist;
    private int artistId;
    private Impresario impresario;
    private int impresarioId;

    public ArtistAndImpresario() {
    }

    public ArtistAndImpresario(int artistId, int impresarioId) {
        this.artistId = artistId;
        this.impresarioId = impresarioId;
    }

    public ArtistAndImpresario(Artist artist, Impresario impresario) {
        this.artist = artist;
        this.impresario = impresario;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getImpresarioId() {
        return impresarioId;
    }

    public void setImpresarioId(int impresarioId) {
        this.impresarioId = impresarioId;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Impresario getImpresario() {
        return impresario;
    }

    public void setImpresario(Impresario impresario) {
        this.impresario = impresario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistAndImpresario that = (ArtistAndImpresario) o;

        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        return impresario != null ? impresario.equals(that.impresario) : that.impresario == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (impresario != null ? impresario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtistAndImpresario{" +
                "artist=" + artist +
                ", impresario=" + impresario +
                '}';
    }
}
