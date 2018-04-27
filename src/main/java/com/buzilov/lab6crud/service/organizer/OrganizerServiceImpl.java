package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.dao.organizer.OrganizerDAO;
import com.buzilov.lab6crud.model.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerDAO organizerDAO;

    @Override
    public Organizer insert(Organizer organizer) throws SQLException {
        return organizerDAO.save(organizer);
    }

    @Override
    public Organizer get(int id) throws SQLException {
        return organizerDAO.findById(id).get();
    }

    @Override
    public Organizer update(Organizer organizer) throws SQLException {
        return organizerDAO.save(organizer);
    }

    @Override
    public void delete(int id) throws SQLException {
        organizerDAO.deleteById(id);
    }

    @Override
    public List<Organizer> getAll() throws SQLException {
        return (List<Organizer>) organizerDAO.findAll();
    }
}
