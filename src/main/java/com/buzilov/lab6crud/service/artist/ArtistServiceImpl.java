package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.repository.artist.ArtistRepository;
import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.repository.impresario.ImpresarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ImpresarioRepository impresarioRepository;

    @Override
    public Artist updateArtistImpresarios(Artist artist) throws SQLException {
        Artist updatedArtist = artistRepository.findById(artist.getId()).get();
        List <Integer> ids = new ArrayList<>(artist.getImpresarioIds());
        for (int i = 0; i < ids.size(); i++){
            updatedArtist.getImpresarios().add(impresarioRepository.findById(ids.get(i)).get());
        }
        System.out.println("IMPRESARIOS: " + updatedArtist.getImpresarios());
        return artistRepository.save(updatedArtist);
    }

    @Override
    public Artist deleteImpresario(Artist artist) throws SQLException {
        Artist updatedArtist = artistRepository.findById(artist.getId()).get();
        updatedArtist.getImpresarioIds().removeAll(artist.getImpresarioIds());
        List<Integer> ids = new ArrayList<>(artist.getImpresarioIds());
        for (int i = 0; i < ids.size(); i++){
            updatedArtist.getImpresarios().remove(impresarioRepository.findById(ids.get(i)).get());
        }
        return artistRepository.save(updatedArtist);
    }

    @Override
    public Artist insertArtist(Artist artist) throws SQLException {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtist(int id) throws SQLException {
        return artistRepository.findById(id).get();
    }

    @Override
    public Artist updateArtist(Artist artist) throws SQLException{
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

    @Override
    public List<Artist> findAllByGenreSetContaining(Genre genre) {
        return artistRepository.findAllByGenreSetContaining(genre);
    }

    @Override
    public List<Artist> findArtistByImpresariosContaining(Impresario impresario) {
        return artistRepository.findArtistByImpresariosContaining(impresario);
    }

    @Override
    public List<Artist> findAllByHavingMoreThanOneGenre() {
        List<Artist> artistList = artistRepository.findAll();
        List<Artist> listToShow = new ArrayList<>();

        for (Artist a : artistList)
            if (a.getGenreSet().size() > 1) listToShow.add(a);

        return listToShow;
    }

    @Override
    public List<Artist> findAllByHavingMoreThanOneImpresario() {
        List<Artist> artistList = artistRepository.findAll();
        List<Artist> listToShow = new ArrayList<>();

        for (Artist a : artistList)
            if (a.getImpresarios().size() > 1) listToShow.add(a);

        return listToShow;
    }

    @Override
    public Set<Impresario> findArtistImpresarios(int id) {
        return artistRepository.findById(id).get().getImpresarios();
    }

    @Override
    public List<Artist> findAllByContestDateNotBetween(LocalDate firstDate, LocalDate secondDate) {
        return artistRepository.findAllByContestDateNotBetween(firstDate, secondDate);
    }

    @Override
    public List<Artist> findAllByGenreSetIsNull() {
        return artistRepository.findAllByGenreSetIsNull();
    }
}
