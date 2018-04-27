package com.buzilov.lab6crud.service.theatre;

import com.buzilov.lab6crud.dao.theatre.TheatreDAO;
import com.buzilov.lab6crud.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreDAO theatreDAO;

    @Override
    public Theatre insert(Theatre theatre) throws SQLException {
        return theatreDAO.save(theatre);
    }

    @Override
    public Theatre get(int id) throws SQLException {
        return theatreDAO.findById(id).get();
    }

    @Override
    public Theatre update(Theatre theatre) throws SQLException {
        return theatreDAO.save(theatre);
    }

    @Override
    public void delete(int id) throws SQLException {
        theatreDAO.deleteById(id);
    }

    @Override
    public List<Theatre> getAll() throws SQLException {
        return (List<Theatre>) theatreDAO.findAll();
    }
}
