package com.buzilov.lab6crud.service.concerthall;

import com.buzilov.lab6crud.dao.concerthall.ConcertHallDAO;
import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConcertHallServiceImpl implements ConcertHallService{
    @Autowired
    ConcertHallDAO concertHallDAO;

    @Override
    public ConcertHall insert(ConcertHall concertHall) throws SQLException {
        return concertHallDAO.save(concertHall);
    }

    @Override
    public ConcertHall get(int id) throws SQLException {
        return concertHallDAO.findById(id).get();
    }

    @Override
    public ConcertHall update(ConcertHall concertHall) throws SQLException {
        return concertHallDAO.save(concertHall);
    }

    @Override
    public void delete(int id) throws SQLException {
        concertHallDAO.deleteById(id);
    }

    @Override
    public List<ConcertHall> getAll() throws SQLException {
        return (List<ConcertHall>)concertHallDAO.findAll();
    }
}
