package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ContestInPalace;
import com.buzilov.lab6crud.service.contestinpalace.ContestInPalaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/contestinpalace")
public class ContestInPalaceController {
    @Autowired
    ContestInPalaceServiceImpl contestInPalaceService;

    @RequestMapping("/showall")
    public List<ContestInPalace> showContestsInPalaces() throws SQLException {
        return contestInPalaceService.getAll();
    }

    @RequestMapping("/insert")
    public ContestInPalace insert(@RequestBody ContestInPalace contestInPalace) throws SQLException {
        if (contestInPalace.getDate() == null){
            contestInPalace.setDate(LocalDate.of(2018, 1, 1));
        }
        return contestInPalaceService.insert(contestInPalace);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) throws SQLException {
        System.out.println("delete");
        contestInPalaceService.delete(id);
    }

    @RequestMapping("/update")
    public ContestInPalace update(@RequestBody ContestInPalace contestInPalace) throws SQLException {
        if (contestInPalace.getDate() == null){
            contestInPalace.setDate(LocalDate.of(2018, 1, 1));
        }
        return contestInPalaceService.update(contestInPalace);
    }

    @RequestMapping("/findAllByDateBetween")
    public List<ContestInPalace> findAllByDateBetween(@RequestParam("firstDate") String firstDateStr,
                                                    @RequestParam("secondDate") String secondDateStr) {
        System.out.println("In datebetween");
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        return contestInPalaceService.findAllByDateBetween(firstDate, secondDate);
    }

    @RequestMapping("/findAllByDateBetweenAndOrganizer")
    public List<ContestInPalace> findAllByDateBetweenAndOrganizer(@RequestParam("firstDate") String firstDateStr,
                                                                @RequestParam("secondDate") String secondDateStr,
                                                                @RequestParam("organizerId") int organizerId) {
        LocalDate firstDate = LocalDate.parse(firstDateStr);
        LocalDate secondDate = LocalDate.parse(secondDateStr);


        return contestInPalaceService.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId);
    }

    @RequestMapping("/findAllByCulturePalaceId")
    public List<ContestInPalace> findAllByCulturePalaceId(@RequestParam("id") int id){
        return contestInPalaceService.findAllByCulturePalaceId(id);
    }
}