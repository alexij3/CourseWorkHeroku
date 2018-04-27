package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.service.organizer.OrganizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {
    @Autowired
    OrganizerServiceImpl service;

    @RequestMapping("/get")
    public Organizer get(@RequestParam("id") int id) throws SQLException {
        return service.get(id);
    }

    @RequestMapping("/showAll")
    public List<Organizer> getAll() throws SQLException {
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException{
        System.out.println("kek");
        service.delete(id);
    }

    @RequestMapping("/create")
    public Organizer create(String name) throws SQLException {
        Organizer organizer = new Organizer(name);
        return service.insert(organizer);
    }

    @RequestMapping("/update")
    public Organizer update(@RequestParam("id") Integer id, @RequestBody Organizer organizer) throws SQLException{
        organizer.setId(id);
        return service.update(organizer);
    }
}
