package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.repository.organizer.OrganizerRepository;
import com.buzilov.lab6crud.model.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public Organizer insert(Organizer organizer) throws SQLException {
        return organizerRepository.save(organizer);
    }

    @Override
    public Organizer get(int id) throws SQLException {
        return organizerRepository.findById(id).get();
    }

    @Override
    public Organizer update(Organizer organizer) throws SQLException {
        return organizerRepository.save(organizer);
    }

    @Override
    public void delete(int id) throws SQLException {
        organizerRepository.deleteById(id);
    }

    @Override
    public List<Organizer> getAll() throws SQLException {
        return (List<Organizer>) organizerRepository.findAll();
    }

    @Override
    public List<Organizer> findAllAndConcertCount(LocalDate firstDate, LocalDate secondDate) {
        return organizerRepository.findAllAndConcertCount(firstDate, secondDate);
    }

    @Override
    public List<Organizer> findAllByAgeLessThan(int age) {
        return organizerRepository.findAllByAgeLessThan(age);
    }

    @Override
    public List<Organizer> findAllByAgeGreaterThanEqual(int age) {
        return organizerRepository.findAllByAgeGreaterThanEqual(age);
    }

    @Override
    public List<Organizer> findAllByExperienceLessThan(int experience) {
        return organizerRepository.findAllByExperienceLessThan(experience);
    }

    @Override
    public List<Organizer> findAllByExperienceGreaterThanEqual(int experience) {
        return organizerRepository.findAllByExperienceGreaterThanEqual(experience);
    }
}
