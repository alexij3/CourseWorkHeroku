package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.repository.artist.ArtistRepository;
import com.buzilov.lab6crud.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Override
    public Artist insertArtist(Artist artist) throws SQLException {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtist(int id) throws SQLException {
        return artistRepository.findById(id).get();
    }

    @Override
    public Artist updateArtist(Artist artist){
        return artistRepository.save(artist);
    }

    @Override
    public Artist updateArtistGenres(Artist artist) throws SQLException {
        Artist updatedArtist = getArtist(artist.getId());
        updatedArtist.getGenreSet().addAll(artist.getGenreSet());
        return artistRepository.save(updatedArtist);
    }

    @Override
    public void deleteArtist(int id) throws SQLException {
        artistRepository.deleteById(id);
    }

    @Override
    public List<Artist> getAll() throws SQLException {
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Artist deleteGenre(Artist artist) throws SQLException {
        Artist updatedArtist = artistRepository.findById(artist.getId()).get();
        updatedArtist.getGenreSet().removeAll(artist.getGenreSet());
        return artistRepository.save(updatedArtist);
    }
}
