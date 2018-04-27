package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.dao.artist.ArtistDAO;
import com.buzilov.lab6crud.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistDAO artistDAO;

    @Override
    public Artist insertArtist(Artist artist) throws SQLException {
        return artistDAO.save(artist);
    }

    @Override
    public Artist getArtist(int id) throws SQLException {
        return artistDAO.findById(id).get();
    }

    @Override
    public Artist updateArtist(Artist artist) throws SQLException {
        return artistDAO.save(artist);
    }

    @Override
    public void deleteArtist(int id) throws SQLException {
        artistDAO.deleteById(id);
    }

    @Override
    public List<Artist> getAll() throws SQLException {
        return (List<Artist>)artistDAO.findAll();
    }
}
