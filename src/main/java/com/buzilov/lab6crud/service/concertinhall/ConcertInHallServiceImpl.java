package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.repository.concertinhall.ConcertInHallRepository;
import com.buzilov.lab6crud.model.ConcertInHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConcertInHallServiceImpl implements ConcertInHallService {
    @Autowired
    ConcertInHallRepository concertInHallRepository;

    @Override
    public ConcertInHall insert(ConcertInHall concertInHall) throws SQLException {
        return concertInHallRepository.save(concertInHall);
    }

    @Override
    public ConcertInHall get(int id) throws SQLException {
        return concertInHallRepository.findById(id).get();
    }

    @Override
    public ConcertInHall update(ConcertInHall concertInHall) throws SQLException {
        return concertInHallRepository.save(concertInHall);
    }

    @Override
    public void delete(int id) throws SQLException {
        concertInHallRepository.deleteById(id);
    }

    @Override
    public List<ConcertInHall> getAll() throws SQLException {
        return (List<ConcertInHall>) concertInHallRepository.findAll();
    }
}

