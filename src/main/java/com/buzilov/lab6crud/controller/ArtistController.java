package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.service.artist.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @RequestMapping("/showall")
    public List<Artist> showArtists() throws SQLException {
        return artistService.getAll();
    }

    @RequestMapping("/delete")
    public void deleteArtist(@RequestParam("id") int id) throws SQLException {
        artistService.deleteArtist(id);
    }

    @RequestMapping("/update")
    public Artist updateArtist(@RequestParam("id") Integer id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        return artistService.updateArtist(artist);
    }

    @RequestMapping("/create")
    public Artist create(@RequestBody Artist artist) throws SQLException {
        return artistService.insertArtist(artist);
    }

    @RequestMapping("/get")
    public Artist get(@RequestParam("id") int id) throws SQLException{
        return artistService.getArtist(id);
    }

}

