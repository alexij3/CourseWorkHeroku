package com.buzilov.lab6crud.service.concerthall;

import com.buzilov.lab6crud.model.ConcertHall;

import java.sql.SQLException;
import java.util.List;

public interface ConcertHallService {
    ConcertHall insert(ConcertHall concertHall)throws SQLException;
    ConcertHall get(int id)throws SQLException;
    ConcertHall update(ConcertHall concertHall)throws SQLException;
    void delete(int id)throws SQLException;
    List<ConcertHall> getAll()throws SQLException;
    List<ConcertHall> findAllByCapacityGreaterThanEqual(int capacity);
}
