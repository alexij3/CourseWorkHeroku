package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.model.Artist;

import java.sql.SQLException;
import java.util.List;

public interface ArtistService {
    Artist insertArtist(Artist artist) throws SQLException;
    Artist getArtist(int id) throws SQLException;
    Artist updateArtist(Artist artist) throws SQLException;
    Artist updateArtistGenres(Artist artist) throws SQLException;
    void deleteArtist(int id) throws SQLException;
    Artist deleteGenre(Artist artist) throws SQLException;
    List<Artist> getAll() throws SQLException;
}
