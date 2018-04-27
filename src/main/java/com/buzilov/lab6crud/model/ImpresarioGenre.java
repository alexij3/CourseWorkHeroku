package com.buzilov.lab6crud.model;

public class ImpresarioGenre {
    private Impresario impresario;
    private int impresarioId;
    private Genre genre;

    public ImpresarioGenre() {
    }

    public ImpresarioGenre(int impresarioId, Genre genre) {
        this.impresarioId = impresarioId;
        this.genre = genre;
    }

    public ImpresarioGenre(Impresario impresario) {
        this.impresario = impresario;
    }

    public ImpresarioGenre(Impresario impresario, Genre genre) {
        this.impresario = impresario;
        this.genre = genre;
    }

    public Impresario getImpresario() {
        return impresario;
    }

    public void setImpresario(Impresario impresario) {
        this.impresario = impresario;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getImpresarioId() {
        return impresarioId;
    }



    public void setImpresarioId(int impresarioId) {
        this.impresarioId = impresarioId;
    }

    @Override
    public String toString() {
        return "ImpresarioGenre{" +
                "impresario=" + impresario +
                ", genre=" + genre +
                '}';
    }
}
