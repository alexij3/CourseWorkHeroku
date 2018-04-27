/*
package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ConcertInHall;
import com.buzilov.lab6crud.service.concertinhall.ConcertInHallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/concertinhall")
public class ConcertInHallController {
    @Autowired
    ConcertInHallServiceImpl concertInHallService;

    @RequestMapping("/showall")
    public List<ConcertInHall> showContestsInPalaces() throws SQLException {
        return concertInHallService.getAll();
    }

    @RequestMapping("/insert")
    public ConcertInHall insert(@RequestBody ConcertInHall concertInHall) throws SQLException {
        if (concertInHall.getDate() == null){
            concertInHall.setDate(LocalDate.of(2018, 1, 1));
        }
        return concertInHallService.insert(concertInHall);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) throws SQLException {
        System.out.println("delete");
        concertInHallService.delete(id);
    }

    @RequestMapping("/update")
    public ConcertInHall update(@RequestBody ConcertInHall concertInHall) throws SQLException {
        if (concertInHall.getDate() == null){
            concertInHall.setDate(LocalDate.of(2018, 1, 1));
        }
        return concertInHallService.update(concertInHall);
    }
}
*/
