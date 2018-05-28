package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.repository.theatreperformance.TheatrePerformanceRepository;
import com.buzilov.lab6crud.service.theatre.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImpl service;

    @RequestMapping("/showAll")
    public List<Theatre> getAll() throws SQLException {
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException {
        System.out.println("kek");
        service.delete(id);
    }

    @RequestMapping("/create")
    public Theatre create(@RequestBody Theatre Theatre) throws SQLException {
        return service.insert(Theatre);
    }

    @RequestMapping("/update")
    public Theatre update(@RequestParam("id") Integer id, @RequestBody Theatre Theatre) throws SQLException {
        Theatre.setId(id);
        return service.update(Theatre);

    }

    @RequestMapping("/findAllByCapacityGreaterThanEqual")
    public List<Theatre> findAllByCapacityGreaterThanEqual(@RequestParam("capacity") int capacity){
        return service.findAllByCapacityGreaterThanEqual(capacity);
    }
}
