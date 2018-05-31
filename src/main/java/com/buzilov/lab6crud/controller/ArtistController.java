package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.repository.artist.ArtistRepository;
import com.buzilov.lab6crud.service.artist.ArtistServiceImpl;
import com.buzilov.lab6crud.service.impresario.ImpresarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @Autowired
    ImpresarioServiceImpl impresarioService;

    @RequestMapping("/showall")
    public List<Artist> showArtists() throws SQLException {
        return artistService.getAll();
    }

    @RequestMapping("/delete")
    public void deleteArtist(@RequestParam("id") int id) throws SQLException {
        artistService.deleteArtist(id);
    }

    @RequestMapping("/deletegenre")
    public void deleteGenre(@RequestParam("artistId") int id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        System.out.println(artist.getGenreSet());
        artistService.deleteGenre(artist);
    }

    @RequestMapping("/deleteimpresarios")
    public void deleteImpresario(@RequestParam("artistId") int id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        artistService.deleteImpresario(artist);
    }

    @RequestMapping("/update")
    public Artist updateArtist(@RequestParam("id") Integer id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        return artistService.updateArtist(artist);
    }

    @RequestMapping("/updateimpresarios")
    public Artist updateArtistImpresarios(@RequestParam("id") Integer id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        System.out.println("IMPRESARIOS: " + artist.getImpresarioIds());
        return artistService.updateArtistImpresarios(artist);
    }

    @RequestMapping("/updategenres")
    public Artist updateArtistGenres(@RequestParam("id") Integer id, @RequestBody Artist artist) throws SQLException {
        artist.setId(id);
        System.out.println("update genres");
        return artistService.updateArtistGenres(artist);
    }

    @RequestMapping("/create")
    public Artist create(@RequestBody Artist artist) throws SQLException {
        return artistService.insertArtist(artist);
    }

    @RequestMapping("/get")
    public Artist get(@RequestParam("id") int id) throws SQLException{
        return artistService.getArtist(id);
    }

    @RequestMapping("findAllByGenreSetContaining")
    public List<Artist> findAllByGenreSetContaining(@RequestParam("genre") Genre genre){
        return artistService.findAllByGenreSetContaining(genre);
    }

    @RequestMapping("findArtistByImpresariosContaining")
    public List<Artist> findArtistByImpresariosContaining(@RequestParam("id") int id, @RequestBody Impresario impresario){
        impresario.setId(id);

        return artistService.findArtistByImpresariosContaining(impresario);
    }

    @RequestMapping("findAllByHavingMoreThanOneGenre")
    public List<Artist> findAllByHavingMoreThanOneGenre(){
        return artistService.findAllByHavingMoreThanOneGenre();
    }

    @RequestMapping("findAllByHavingMoreThanOneImpresario")
    public List<Artist> findAllByHavingMoreThanOneImpresario(){
        return artistService.findAllByHavingMoreThanOneImpresario();
    }

    @RequestMapping("findArtistImpresarios")
    public Set<Impresario> findArtistImpresarios(int id){
        return artistService.findArtistImpresarios(id);
    }

    @RequestMapping("/findAllByContestDateNotBetween")
    public List<Artist> findAllByContestDateNotBetween(@RequestParam("firstDate") String firstDateStr,
                                                       @RequestParam("secondDate") String secondDateStr){
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return artistService.findAllByContestDateNotBetween(firstDate, secondDate);
    }

    @RequestMapping("/findAllByGenreSetIsNull")
    public List<Artist> findAllByGenreSetIsNull(){
        return artistService.findAllByGenreSetIsNull();
    }

    @RequestMapping("/findAllByAgeLessThan")
    public List<Artist> findAllByAgeLessThan(int age) {
        return artistService.findAllByAgeLessThan(age);
    }

    @RequestMapping("/findAllByAgeGreaterThanEqual")
    public List<Artist> findAllByAgeGreaterThanEqual(int age) {
        return artistService.findAllByAgeGreaterThanEqual(age);
    }

    @RequestMapping("/findAllByExperienceLessThan")
    public List<Artist> findAllByExperienceLessThan(int experience) {
        return artistService.findAllByExperienceLessThan(experience);
    }

    @RequestMapping("/findAllByExperienceGreaterThanEqual")
    public List<Artist> findAllByExperienceGreaterThanEqual(int experience) {
        return artistService.findAllByExperienceGreaterThanEqual(experience);
    }

}

