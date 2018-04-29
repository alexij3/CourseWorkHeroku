package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.dao.concertinhall.ConcertInHallDAO;
import com.buzilov.lab6crud.model.ConcertInHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConcertInHallServiceImpl implements ConcertInHallService {
    @Autowired
    ConcertInHallDAO concertInHallDAO;

    @Override
    public ConcertInHall insert(ConcertInHall concertInHall) throws SQLException {
        return concertInHallDAO.save(concertInHall);
    }

    @Override
    public ConcertInHall get(int id) throws SQLException {
        return concertInHallDAO.findById(id).get();
    }

    @Override
    public ConcertInHall update(ConcertInHall concertInHall) throws SQLException {
        return concertInHallDAO.save(concertInHall);
    }

    @Override
    public void delete(int id) throws SQLException {
        concertInHallDAO.deleteById(id);
    }

    @Override
    public List<ConcertInHall> getAll() throws SQLException {
        return (List<ConcertInHall>) concertInHallDAO.findAll();
    }
}

