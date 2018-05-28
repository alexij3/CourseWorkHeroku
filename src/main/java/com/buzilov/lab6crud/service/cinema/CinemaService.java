package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.model.Cinema;

import java.sql.SQLException;
import java.util.List;

public interface CinemaService {
    Cinema insertCinema(Cinema cinema) throws SQLException;
    Cinema getCinema(int id) throws SQLException;
    Cinema updateCinema(Cinema cinema) throws SQLException;
    void deleteCinema(int id) throws SQLException;
    List<Cinema> getAll() throws SQLException;
    List<Cinema> findAllByScreenSizeGreaterThanEqual(int size);
}
