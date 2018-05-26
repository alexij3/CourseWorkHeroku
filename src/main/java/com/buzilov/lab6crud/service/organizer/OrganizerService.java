package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.model.Organizer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrganizerService {
    Organizer insert(Organizer organizer) throws SQLException;
    Organizer get(int id) throws SQLException;
    Organizer update(Organizer organizer) throws SQLException;
    void delete(int id) throws SQLException;
    List<Organizer> getAll() throws SQLException;
    List<Organizer> findAllAndConcertCount(LocalDate firstDate, LocalDate secondDate);
}
