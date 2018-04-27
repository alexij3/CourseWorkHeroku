package com.buzilov.lab6crud.service.artistgenre;

import com.buzilov.lab6crud.model.ArtistGenre;
import com.buzilov.lab6crud.model.Genre;

import java.sql.SQLException;
import java.util.List;

public interface ArtistGenreService {
    ArtistGenre get(int id) throws SQLException;
    ArtistGenre update(String oldGenre, ArtistGenre artistGenre) throws SQLException;
    void delete(int id, Genre genre) throws SQLException;
    ArtistGenre insert(ArtistGenre artistGenre) throws SQLException;
    List<ArtistGenre> getAll() throws SQLException;
}
