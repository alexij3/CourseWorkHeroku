package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.repository.cinema.CinemaRepository;
import com.buzilov.lab6crud.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;

    @Override
    public Cinema insertCinema(Cinema cinema)throws SQLException {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema getCinema(int id)throws SQLException {
        return cinemaRepository.findById(id).get();
    }

    @Override
    public Cinema updateCinema(Cinema cinema)throws SQLException {
        return cinemaRepository.save(cinema);
    }

    @Override
    public void deleteCinema(int id)throws SQLException {
        cinemaRepository.deleteById(id);
    }

    @Override
    public List<Cinema> getAll() throws SQLException{
        return (List<Cinema>) cinemaRepository.findAll();
    }

    @Override
    public List<Cinema> findAllByScreenSizeGreaterThanEqual(int size) {
        return cinemaRepository.findAllByScreenSizeGreaterThanEqual(size);
    }
}
