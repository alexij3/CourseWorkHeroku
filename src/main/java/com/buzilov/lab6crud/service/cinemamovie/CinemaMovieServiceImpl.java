package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.dao.cinemamovie.CinemaMovieDAO;
import com.buzilov.lab6crud.model.CinemaMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CinemaMovieServiceImpl implements CinemaMovieService{
    @Autowired
    CinemaMovieDAO cinemaMovieDAO;

    @Override
    public CinemaMovie insert(CinemaMovie cinemaMovie)  throws SQLException {
        return cinemaMovieDAO.save(cinemaMovie);
    }

    @Override
    public CinemaMovie get(int id) throws SQLException {
        return cinemaMovieDAO.findById(id).get();
    }

    @Override
    public CinemaMovie update(CinemaMovie cinemaMovie)  throws SQLException{
        return cinemaMovieDAO.save(cinemaMovie);
    }

    @Override
    public void delete(int id) throws SQLException {
        cinemaMovieDAO.deleteById(id);
    }

    @Override
    public List<CinemaMovie> getAll() throws SQLException {
        return (List<CinemaMovie>)cinemaMovieDAO.findAll();
    }
}
