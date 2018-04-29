package com.buzilov.lab6crud.service.contestinpalace;

import com.buzilov.lab6crud.dao.contestinpalace.ContestInPalaceDAO;
import com.buzilov.lab6crud.model.ContestInPalace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContestInPalaceServiceImpl implements ContestInPalaceService {
    @Autowired
    ContestInPalaceDAO contestInPalaceDAO;

    @Override
    public ContestInPalace insert(ContestInPalace contest) throws SQLException {
        return contestInPalaceDAO.save(contest);
    }

    @Override
    public ContestInPalace get(int id) throws SQLException {
        return contestInPalaceDAO.findById(id).get();
    }

    @Override
    public ContestInPalace update(ContestInPalace contest) throws SQLException {
        return contestInPalaceDAO.save(contest);
    }

    @Override
    public void delete(int id) throws SQLException {
        contestInPalaceDAO.deleteById(id);
    }

    @Override
    public List<ContestInPalace> getAll() throws SQLException {
        return (List<ContestInPalace>) contestInPalaceDAO.findAll();
    }
}
