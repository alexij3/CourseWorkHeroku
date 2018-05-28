package com.buzilov.lab6crud.service.culturepalace;

import com.buzilov.lab6crud.model.CulturePalace;

import java.sql.SQLException;
import java.util.List;

public interface CulturePalaceService {
    CulturePalace insert(CulturePalace culturePalace)throws SQLException;
    CulturePalace get(int id)throws SQLException ;
    CulturePalace update(CulturePalace culturePalace)throws SQLException ;
    void delete(int id)throws SQLException ;
    List<CulturePalace> getAll()throws SQLException ;
    List<CulturePalace> findAllByCapacityGreaterThanEqual(int capacity);
}
