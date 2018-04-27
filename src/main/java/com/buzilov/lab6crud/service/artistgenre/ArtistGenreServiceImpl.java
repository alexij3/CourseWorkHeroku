/*
package com.buzilov.lab6crud.service.artistgenre;

import com.buzilov.lab6crud.dao.artistgenre.ArtistGenreDAOImpl;
import com.buzilov.lab6crud.model.ArtistGenre;
import com.buzilov.lab6crud.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArtistGenreServiceImpl implements ArtistGenreService {
    @Autowired
    ArtistGenreDAOImpl artistGenreDAO;

    @Override
    public ArtistGenre get(int id) throws SQLException {
        return artistGenreDAO.get(id);
    }

    @Override
    public ArtistGenre update(String oldGenre, ArtistGenre artistGenre) throws SQLException {
        return artistGenreDAO.update(oldGenre, artistGenre);
    }

    @Override
    public void delete(int id, Genre genre) throws SQLException {
        artistGenreDAO.delete(id, genre);
    }

    @Override
    public ArtistGenre insert(ArtistGenre artistGenre) throws SQLException {
        return artistGenreDAO.insert(artistGenre);
    }

    @Override
    public List<ArtistGenre> getAll() throws SQLException {
        return artistGenreDAO.getAll();
    }
}
*/
