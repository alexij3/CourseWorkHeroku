package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.dao.organizer.OrganizerDAOImpl;
import com.buzilov.lab6crud.model.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerDAOImpl organizerDAO;

    @Override
    public Organizer insert(Organizer organizer) throws SQLException {
        return organizerDAO.insert(organizer);
    }

    @Override
    public Organizer get(int id) throws SQLException {
        return organizerDAO.get(id);
    }

    @Override
    public Organizer update(Organizer organizer) throws SQLException {
        return organizerDAO.update(organizer);
    }

    @Override
    public void delete(int id) throws SQLException {
        organizerDAO.delete(id);
    }

    @Override
    public List<Organizer> getAll() throws SQLException {
        return organizerDAO.getAll();
    }
}
