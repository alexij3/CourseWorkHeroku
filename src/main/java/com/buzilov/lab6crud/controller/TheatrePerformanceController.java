package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.TheatrePerformance;
import com.buzilov.lab6crud.service.theatreperformance.TheatrePerformanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/theatreperformance")
public class TheatrePerformanceController {
    @Autowired
    TheatrePerformanceServiceImpl theatrePerformanceService;

    @RequestMapping("/showall")
    public List<TheatrePerformance> show() throws SQLException {
        return theatrePerformanceService.getAll();
    }

    @RequestMapping("/insert")
    public TheatrePerformance insert(@RequestBody TheatrePerformance theatrePerformance) throws SQLException {
        if (theatrePerformance.getDate() == null){
            theatrePerformance.setDate(LocalDate.of(2018, 1, 1));
        }
        return theatrePerformanceService.insert(theatrePerformance);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) throws SQLException {
        System.out.println("delete");
        theatrePerformanceService.delete(id);
    }

    @RequestMapping("/update")
    public TheatrePerformance update(@RequestBody TheatrePerformance theatrePerformance) throws SQLException {
        if (theatrePerformance.getDate() == null){
            theatrePerformance.setDate(LocalDate.of(2018, 1, 1));
        }
        return theatrePerformanceService.update(theatrePerformance);
    }

    @RequestMapping("findTheatresAndPerformancesDates")
    public List<TheatrePerformance> findTheatresAndPerformancesDates(@RequestParam("firstDate") String firstDateStr,
                                                                     @RequestParam("secondDate") String secondDateStr){
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);


        return theatrePerformanceService.findTheatresAndPerformancesDates(firstDate, secondDate);
    }

}
