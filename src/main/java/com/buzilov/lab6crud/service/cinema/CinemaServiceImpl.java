package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.dao.cinema.CinemaDAO;
import com.buzilov.lab6crud.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaDAO cinemaDAO;

    @Override
    public Cinema insertCinema(Cinema cinema)throws SQLException {
        return cinemaDAO.save(cinema);
    }

    @Override
    public Cinema getCinema(int id)throws SQLException {
        return cinemaDAO.findById(id).get();
    }

    @Override
    public Cinema updateCinema(Cinema cinema)throws SQLException {
        return cinemaDAO.save(cinema);
    }

    @Override
    public void deleteCinema(int id)throws SQLException {
        cinemaDAO.deleteById(id);
    }

    @Override
    public List<Cinema> getAll() throws SQLException{
        return (List<Cinema>)cinemaDAO.findAll();
    }
}
