package com.buzilov.lab6crud.service.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ContestInPalaceService {
    ContestInPalace insert(ContestInPalace contest)  throws SQLException;
    ContestInPalace get(int id) throws SQLException;
    ContestInPalace update(ContestInPalace contest) throws SQLException;
    void delete(int id) throws SQLException;
    List<ContestInPalace> getAll() throws SQLException;
    List<ContestInPalace> findAllByDateBetween(LocalDate firstDate, LocalDate secondDate);
    List<ContestInPalace> findAllByDateBetweenAndOrganizerId(LocalDate firstDate, LocalDate secondDate,
                                                           int organizerId);
    List<ContestInPalace> findAllByCulturePalaceId(int id);
    List<ContestInPalace> findPalacesAndContestsDates(LocalDate firstDate, LocalDate secondDate);
}
