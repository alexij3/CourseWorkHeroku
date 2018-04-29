package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.CinemaMovie;
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
        CinemaMovie.setCinema(cinemaService.getCinema(CinemaMovie.getCinemaId()));
        if (CinemaMovie.getDate() == null){
            CinemaMovie.setDate(LocalDate.of(2018, 1, 1));
        }
        return service.insert(CinemaMovie);
    }

    @RequestMapping("/update")
    public CinemaMovie update(@RequestParam("id") Integer id, @RequestBody CinemaMovie CinemaMovie) throws SQLException{
        CinemaMovie.setId(id);
        CinemaMovie.setCinema(cinemaService.getCinema(CinemaMovie.getCinemaId()));
        if (CinemaMovie.getDate() == null){
            CinemaMovie.setDate(LocalDate.of(2018, 1, 1));
        }
        System.out.println(CinemaMovie);
        return service.update(CinemaMovie);
    }

}
