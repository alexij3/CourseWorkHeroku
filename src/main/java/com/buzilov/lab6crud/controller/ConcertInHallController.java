package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ConcertInHall;
import com.buzilov.lab6crud.model.Organizer;
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
    public List<ConcertInHall> showConcerts() throws SQLException {
        return concertInHallService.getAll();
    }

    @RequestMapping("/insert")
    public ConcertInHall insert(@RequestBody ConcertInHall concertInHall) throws SQLException {
        if (concertInHall.getDate() == null) {
            concertInHall.setDate(LocalDate.of(2018, 1, 1));
        }
        return concertInHallService.insert(concertInHall);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) throws SQLException {
        System.out.println("delete");
        concertInHallService.delete(id);
    }

    @RequestMapping("findHallsAndConcertsDates")
    public List<ConcertInHall> findHallsAndConcertsDates(@RequestParam("firstDate") String firstDateStr,
                                                                  @RequestParam("secondDate") String secondDateStr){
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return concertInHallService.findHallsAndConcertsDates(firstDate, secondDate);
    }


    @RequestMapping("/update")
    public ConcertInHall update(@RequestBody ConcertInHall concertInHall) throws SQLException {
        if (concertInHall.getDate() == null) {
            concertInHall.setDate(LocalDate.of(2018, 1, 1));
        }
        return concertInHallService.update(concertInHall);
    }

    @RequestMapping("/findAllByDateBetween")
    public List<ConcertInHall> findAllByDateBetween(@RequestParam("firstDate") String firstDateStr,
                                                    @RequestParam("secondDate") String secondDateStr) {
        System.out.println("In datebetween");
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return concertInHallService.findAllByDateBetween(firstDate, secondDate);
    }

    @RequestMapping("/findAllByDateBetweenAndOrganizer")
    public List<ConcertInHall> findAllByDateBetweenAndOrganizer(@RequestParam("firstDate") String firstDateStr,
                                                                @RequestParam("secondDate") String secondDateStr,
                                                                @RequestParam("organizerId") int organizerId) {
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);


        return concertInHallService.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId);
    }

    @RequestMapping("findAllByConcertHallId")
    public List<ConcertInHall> findAllByConcertHallId(@RequestParam("id") int id){
        return concertInHallService.findAllByConcertHallId(id);
    }

    @RequestMapping("/get")
    public ConcertInHall get(int id) throws SQLException {
        return concertInHallService.get(id);
    }
}

