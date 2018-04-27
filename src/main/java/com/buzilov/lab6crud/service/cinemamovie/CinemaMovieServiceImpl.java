package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.dao.cinemamovie.CinemaMovieDAOImpl;
import com.buzilov.lab6crud.model.CinemaMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CinemaMovieServiceImpl implements CinemaMovieService{
    @Autowired
    CinemaMovieDAOImpl cinemaMovieDAO;

    @Override
    public CinemaMovie insert(CinemaMovie cinemaMovie)  throws SQLException {
        return cinemaMovieDAO.insertCinemaMovie(cinemaMovie);
    }

    @Override
    public CinemaMovie get(int id) throws SQLException {
        return cinemaMovieDAO.getCinemaMovie(id);
    }

    @Override
    public CinemaMovie update(CinemaMovie cinemaMovie)  throws SQLException{
        return cinemaMovieDAO.updateCinemaMovie(cinemaMovie);
    }

    @Override
    public void delete(int id) throws SQLException {
        cinemaMovieDAO.deleteCinemaMovie(id);
    }

    @Override
    public List<CinemaMovie> getAll() throws SQLException {
        return cinemaMovieDAO.getAll();
    }
}
