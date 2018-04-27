/*
package com.buzilov.lab6crud.service.theatreperformance;

import com.buzilov.lab6crud.dao.theatreperformance.TheatrePerformanceDAOImpl;
import com.buzilov.lab6crud.model.TheatrePerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TheatrePerformanceServiceImpl implements TheatrePerformanceService {
    @Autowired
    TheatrePerformanceDAOImpl theatrePerformanceDAO;

    @Override
    public TheatrePerformance insert(TheatrePerformance theatrePerformance) throws SQLException {
        return theatrePerformanceDAO.insert(theatrePerformance);
    }

    @Override
    public TheatrePerformance get(int id) throws SQLException {
        return theatrePerformanceDAO.get(id);
    }

    @Override
    public TheatrePerformance update(TheatrePerformance theatrePerformance) throws SQLException {
        return theatrePerformanceDAO.update(theatrePerformance);
    }

    @Override
    public void delete(int id) throws SQLException {
        theatrePerformanceDAO.delete(id);
    }

    @Override
    public List<TheatrePerformance> getAll() throws SQLException {
        return theatrePerformanceDAO.getAll();
    }
}
*/
