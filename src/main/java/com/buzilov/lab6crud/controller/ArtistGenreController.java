/*
package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ArtistGenre;
import com.buzilov.lab6crud.service.artistgenre.ArtistGenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/artistgenre")
public class ArtistGenreController {
    @Autowired
    ArtistGenreServiceImpl artistGenreService;

    @RequestMapping("/showgenres")
    public List<ArtistGenre> showGenres() throws SQLException {
        return artistGenreService.getAll();
    }

    @RequestMapping("/insertgenre")
    public ArtistGenre insertGenre(@RequestParam("id") int id, @RequestBody ArtistGenre artistGenre) throws SQLException{
        artistGenre.setArtistId(id);
        return artistGenreService.insert(artistGenre);
    }

    @RequestMapping("/deletegenre")
    public void deleteGenre(@RequestParam("id") int id, @RequestBody ArtistGenre artistGenre) throws SQLException {
        artistGenreService.delete(id, artistGenre.getGenre());
    }

    @RequestMapping("/updategenre")
    public ArtistGenre updateGenre(@RequestParam("oldGenre") String oldGenre, @RequestBody ArtistGenre artistGenre) throws SQLException{
        System.out.println(artistGenre);
        return artistGenreService.update(oldGenre, artistGenre);
    }
}
*/
