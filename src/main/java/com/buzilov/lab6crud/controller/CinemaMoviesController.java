package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Cinema;
import com.buzilov.lab6crud.model.CinemaMovie;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.service.cinema.CinemaServiceImpl;
import com.buzilov.lab6crud.service.cinemamovie.CinemaMovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cinemamovie")
public class CinemaMoviesController {
    @Autowired
    CinemaMovieServiceImpl service;

    @Autowired
    CinemaServiceImpl cinemaService;

    @RequestMapping("/showAll")
    public List<CinemaMovie> getAll() throws SQLException {
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException {
        service.delete(id);
    }

    @RequestMapping("/create")
    public CinemaMovie create(@RequestBody CinemaMovie CinemaMovie) throws SQLException{
        Cinema cinema = new Cinema();
        cinema.setId(CinemaMovie.getCinemaId());
        CinemaMovie.setCinema(cinema);

        return service.insert(CinemaMovie);
    }

    @RequestMapping("/update")
    public CinemaMovie update(@RequestParam("id") Integer id, @RequestBody CinemaMovie CinemaMovie) throws SQLException{
        CinemaMovie.setId(id);

        Cinema cinema = new Cinema();
        cinema.setId(CinemaMovie.getCinemaId());
        CinemaMovie.setCinema(cinema);

        CinemaMovie.setCinema(cinema);

        return service.update(CinemaMovie);
    }

    @RequestMapping("findAllByCinemaId")
    public List<CinemaMovie> findAllByCinemaId(@RequestParam("id") int id){
        return service.findAllByCinemaId(id);
    }

    @RequestMapping("/findAllByDateBetween")
    public List<CinemaMovie> findAllByDateBetween(@RequestParam("firstDate") String firstDateStr,
                                                    @RequestParam("secondDate") String secondDateStr) {
        System.out.println("In datebetween");
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return service.findAllByDateBetween(firstDate, secondDate);
    }

    @RequestMapping("/findAllByGenre")
    public List<CinemaMovie> findAllByGenre(@RequestParam("genre") Genre genre){
        return service.findAllByGenre(genre);
    }

    @RequestMapping("/get")
    public CinemaMovie get(int id) throws SQLException {
        return service.get(id);
    }

}
