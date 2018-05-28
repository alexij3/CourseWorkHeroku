package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ArtistService {
    Artist insertArtist(Artist artist) throws SQLException;
    Artist getArtist(int id) throws SQLException;
    Artist updateArtist(Artist artist) throws SQLException;
    Artist updateArtistGenres(Artist artist) throws SQLException;
    Artist updateArtistImpresarios(Artist artist) throws SQLException;
    void deleteArtist(int id) throws SQLException;
    Artist deleteGenre(Artist artist) throws SQLException;
    Artist deleteImpresario(Artist artist) throws SQLException;
    List<Artist> getAll() throws SQLException;
    List<Artist> findAllByGenreSetContaining(Genre genre);
    List<Artist> findArtistByImpresariosContaining(Impresario impresario);
    List<Artist> findAllByHavingMoreThanOneGenre();
    Set<Impresario> findArtistImpresarios(int id);
    List<Artist> findAllByContestDateNotBetween(LocalDate firstDate, LocalDate secondDate);
    List<Artist> findAllByHavingMoreThanOneImpresario();
}
