package com.buzilov.lab6crud.service.culturepalace;

import com.buzilov.lab6crud.repository.culturepalace.CulturePalaceRepository;
import com.buzilov.lab6crud.model.CulturePalace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CulturePalaceServiceImpl implements CulturePalaceService {
    @Autowired
    CulturePalaceRepository culturePalaceRepository;

    @Override
    public CulturePalace insert(CulturePalace culturePalace) throws SQLException {
        return culturePalaceRepository.save(culturePalace);
    }

    @Override
    public CulturePalace get(int id)throws SQLException  {
        return culturePalaceRepository.findById(id).get();
    }

    @Override
    public CulturePalace update(CulturePalace culturePalace)throws SQLException  {
        return culturePalaceRepository.save(culturePalace);
    }

    @Override
    public void delete(int id) throws SQLException  {
        culturePalaceRepository.deleteById(id);
    }

    @Override
    public List<CulturePalace> getAll()throws SQLException  {
        return (List<CulturePalace>) culturePalaceRepository.findAll();
    }
}
