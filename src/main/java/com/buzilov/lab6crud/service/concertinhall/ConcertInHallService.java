package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.model.ConcertInHall;
import com.buzilov.lab6crud.model.Organizer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ConcertInHallService {
    ConcertInHall insert(ConcertInHall concertInHall)  throws SQLException;
    ConcertInHall get(int id) throws SQLException;
    ConcertInHall update(ConcertInHall concertInHall) throws SQLException;
    void delete(int id) throws SQLException;
    List<ConcertInHall> getAll() throws SQLException;
    List<ConcertInHall> findAllByDateBetween(LocalDate firstDate, LocalDate secondDate);
    List<ConcertInHall> findAllByDateBetweenAndOrganizerId(LocalDate firstDate, LocalDate secondDate,
                                                         int organizerId);
    List<ConcertInHall> findAllByConcertHallId(int id);
}
