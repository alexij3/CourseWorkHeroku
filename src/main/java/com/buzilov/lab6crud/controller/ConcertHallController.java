package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ConcertHall;
import com.buzilov.lab6crud.service.concerthall.ConcertHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/concerthall")
public class ConcertHallController {
    @Autowired
    ConcertHallServiceImpl service;

    @RequestMapping("/showAll")
    public List<ConcertHall> getAll() throws SQLException {
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException{
        System.out.println("kek");
        service.delete(id);
    }

    @RequestMapping("/create")
    public ConcertHall create(@RequestBody ConcertHall ConcertHall)throws SQLException{
        return service.insert(ConcertHall);
    }

    @RequestMapping("/update")
    public ConcertHall update(@RequestParam("id") Integer id, @RequestBody ConcertHall ConcertHall)throws SQLException{
        ConcertHall.setId(id);
        return service.update(ConcertHall);
    }

    @RequestMapping("/findAllByCapacityGreaterThanEqual")
    public List<ConcertHall> findAllByCapacityGreaterThanEqual(@RequestParam("capacity") int capacity){
        return service.findAllByCapacityGreaterThanEqual(capacity);
    }

}
