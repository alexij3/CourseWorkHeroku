package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import com.buzilov.lab6crud.model.Genre;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CinemaMovieService {
    CinemaMovie insert(CinemaMovie cinemaMovie) throws SQLException;
    CinemaMovie get(int id)  throws SQLException;
    CinemaMovie update(CinemaMovie cinemaMovie)  throws SQLException;
    void delete(int id)  throws SQLException;
    List<CinemaMovie> getAll() throws SQLException;
    List<CinemaMovie> findAllByCinemaId(int id);
    List<CinemaMovie> findAllByDateBetween(LocalDate firstDate, LocalDate secondDate);
    List<CinemaMovie> findAllByGenre(Genre genre);
}
