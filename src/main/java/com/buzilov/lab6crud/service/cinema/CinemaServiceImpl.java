package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.dao.cinema.CinemaDAOImpl;
import com.buzilov.lab6crud.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaDAOImpl cinemaDAO;

    @Override
    public Cinema insertCinema(Cinema cinema)throws SQLException {
        return cinemaDAO.insertCinema(cinema);
    }

    @Override
    public Cinema getCinema(int id)throws SQLException {
        return cinemaDAO.getCinema(id);
    }

    @Override
    public Cinema updateCinema(Cinema cinema)throws SQLException {
        return cinemaDAO.updateCinema(cinema);
    }

    @Override
    public void deleteCinema(int id)throws SQLException {
        cinemaDAO.deleteCinema(id);
    }

    @Override
    public List<Cinema> getAll() throws SQLException{
        return cinemaDAO.getAll();
    }
}
