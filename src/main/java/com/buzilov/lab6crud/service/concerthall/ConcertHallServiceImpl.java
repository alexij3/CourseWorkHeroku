package com.buzilov.lab6crud.service.concerthall;

import com.buzilov.lab6crud.repository.concerthall.ConcertHallRepository;
import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConcertHallServiceImpl implements ConcertHallService{
    @Autowired
    ConcertHallRepository concertHallRepository;

    @Override
    public ConcertHall insert(ConcertHall concertHall) throws SQLException {
        return concertHallRepository.save(concertHall);
    }

    @Override
    public ConcertHall get(int id) throws SQLException {
        return concertHallRepository.findById(id).get();
    }

    @Override
    public ConcertHall update(ConcertHall concertHall) throws SQLException {
        return concertHallRepository.save(concertHall);
    }

    @Override
    public void delete(int id) throws SQLException {
        concertHallRepository.deleteById(id);
    }

    @Override
    public List<ConcertHall> getAll() throws SQLException {
        return (List<ConcertHall>) concertHallRepository.findAll();
    }
}
