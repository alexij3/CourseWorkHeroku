package com.buzilov.lab6crud.service.concerthall;

import com.buzilov.lab6crud.dao.concerthall.ConcertHallDAOImpl;
import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConcertHallServiceImpl implements ConcertHallService{
    @Autowired
    ConcertHallDAOImpl concertHallDAO;

    @Override
    public ConcertHall insert(ConcertHall concertHall) throws SQLException {
        return concertHallDAO.insert(concertHall);
    }

    @Override
    public ConcertHall get(int id) throws SQLException {
        return concertHallDAO.get(id);
    }

    @Override
    public ConcertHall update(ConcertHall concertHall) throws SQLException {
        return concertHallDAO.update(concertHall);
    }

    @Override
    public void delete(int id) throws SQLException {
        concertHallDAO.delete(id);
    }

    @Override
    public List<ConcertHall> getAll() throws SQLException {
        return concertHallDAO.getAll();
    }
}
