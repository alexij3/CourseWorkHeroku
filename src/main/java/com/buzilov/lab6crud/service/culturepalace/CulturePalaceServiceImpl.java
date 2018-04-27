package com.buzilov.lab6crud.service.culturepalace;

import com.buzilov.lab6crud.dao.culturepalace.CulturePalaceDAOImpl;
import com.buzilov.lab6crud.model.CulturePalace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CulturePalaceServiceImpl implements CulturePalaceService {
    @Autowired
    CulturePalaceDAOImpl culturePalaceDAO;

    @Override
    public CulturePalace insert(CulturePalace culturePalace) throws SQLException {
        return culturePalaceDAO.insert(culturePalace);
    }

    @Override
    public CulturePalace get(int id)throws SQLException  {
        return culturePalaceDAO.get(id);
    }

    @Override
    public CulturePalace update(CulturePalace culturePalace)throws SQLException  {
        return culturePalaceDAO.update(culturePalace);
    }

    @Override
    public void delete(int id) throws SQLException  {
        culturePalaceDAO.delete(id);
    }

    @Override
    public List<CulturePalace> getAll()throws SQLException  {
        return culturePalaceDAO.getAll();
    }
}
