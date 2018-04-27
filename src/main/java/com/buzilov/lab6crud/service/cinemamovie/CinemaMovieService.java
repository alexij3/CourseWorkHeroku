package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;

import java.sql.SQLException;
import java.util.List;

public interface CinemaMovieService {
    CinemaMovie insert(CinemaMovie cinemaMovie) throws SQLException;
    CinemaMovie get(int id)  throws SQLException;
    CinemaMovie update(CinemaMovie cinemaMovie)  throws SQLException;
    void delete(int id)  throws SQLException;
    List<CinemaMovie> getAll() throws SQLException;
}
