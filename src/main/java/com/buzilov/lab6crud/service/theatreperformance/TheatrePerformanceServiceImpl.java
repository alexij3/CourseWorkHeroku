package com.buzilov.lab6crud.service.theatreperformance;

import com.buzilov.lab6crud.model.TheatrePerformance;
import com.buzilov.lab6crud.repository.theatreperformance.TheatrePerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class TheatrePerformanceServiceImpl implements TheatrePerformanceService {
    @Autowired
    TheatrePerformanceRepository theatrePerformanceRepository;

    @Override
    public TheatrePerformance insert(TheatrePerformance theatrePerformance) throws SQLException {
        return theatrePerformanceRepository.save(theatrePerformance);
    }

    @Override
    public TheatrePerformance get(int id) throws SQLException {
        return theatrePerformanceRepository.findById(id).get();
    }

    @Override
    public TheatrePerformance update(TheatrePerformance theatrePerformance) throws SQLException {
        return theatrePerformanceRepository.save(theatrePerformance);
    }

    @Override
    public void delete(int id) throws SQLException {
        theatrePerformanceRepository.deleteById(id);
    }

    @Override
    public List<TheatrePerformance> getAll() throws SQLException {
        return (List<TheatrePerformance>) theatrePerformanceRepository.findAll();
    }

    @Override
    public List<TheatrePerformance> findTheatresAndPerformancesDates(LocalDate firstDate, LocalDate secondDate) {
        return theatrePerformanceRepository.findTheatresAndPerformancesDates(firstDate, secondDate);
    }

    @Override
    public List<TheatrePerformance> findAllByDateBetween(LocalDate firstDate, LocalDate secondDate) {
        return theatrePerformanceRepository.findAllByDateBetween(firstDate, secondDate);
    }

    @Override
    public List<TheatrePerformance> findAllByDateBetweenAndOrganizerId(LocalDate firstDate, LocalDate secondDate, int organizerId) {
        return theatrePerformanceRepository.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId);
    }
}
