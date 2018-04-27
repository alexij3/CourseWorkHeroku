package com.buzilov.lab6crud.service.theatre;

import com.buzilov.lab6crud.dao.theatre.TheatreDAOImpl;
import com.buzilov.lab6crud.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    TheatreDAOImpl theatreDAO;

    @Override
    public Theatre insert(Theatre theatre) throws SQLException {
        return theatreDAO.insert(theatre);
    }

    @Override
    public Theatre get(int id) throws SQLException {
        return theatreDAO.get(id);
    }

    @Override
    public Theatre update(Theatre theatre) throws SQLException {
        return theatreDAO.update(theatre);
    }

    @Override
    public void delete(int id) throws SQLException {
        theatreDAO.delete(id);
    }

    @Override
    public List<Theatre> getAll() throws SQLException {
        return theatreDAO.getAll();
    }
}
