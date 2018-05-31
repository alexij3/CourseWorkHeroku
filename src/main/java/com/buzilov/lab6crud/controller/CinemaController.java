package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Cinema;
import com.buzilov.lab6crud.service.cinema.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
    @Autowired
    CinemaServiceImpl service;

    @RequestMapping("/showall")
    public List<Cinema> showCinemas() throws SQLException{
        System.out.println("showall cinema");
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException{
        service.deleteCinema(id);
    }

    @RequestMapping("/create")
    public Cinema create(@RequestBody Cinema cinema)throws SQLException{
        return service.insertCinema(cinema);
    }

    @RequestMapping("/update")
    public Cinema update(@RequestParam("id") Integer id, @RequestBody Cinema Cinema) throws SQLException {
        Cinema.setId(id);
        return service.updateCinema(Cinema);
    }

    @RequestMapping("/addCinemaMovie")
    public Cinema addCinemaMovie(@RequestBody Cinema cinema) throws SQLException {
        return service.updateCinema(cinema);
    }

    @RequestMapping("/findAllByScreenSizeGreaterThanEqual")
    public List<Cinema> findAllByScreenSizeGreaterThanEqual(@RequestParam("size") int size){
        return service.findAllByScreenSizeGreaterThanEqual(size);
    }

    @RequestMapping("/get")
    public Cinema get(@RequestParam("id") int id) throws SQLException {
        return service.getCinema(id);
    }
}
