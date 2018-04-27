package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.model.ConcertInHall;

import java.sql.SQLException;
import java.util.List;

public interface ConcertInHallService {
    ConcertInHall insert(ConcertInHall concertInHall)  throws SQLException;
    ConcertInHall get(int id) throws SQLException;
    ConcertInHall update(ConcertInHall concertInHall) throws SQLException;
    void delete(int id) throws SQLException;
    List<ConcertInHall> getAll() throws SQLException;
}
