package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.CulturePalace;
import com.buzilov.lab6crud.service.culturepalace.CulturePalaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/culturepalace")
public class CulturePalaceController{
    @Autowired
    CulturePalaceServiceImpl service;

    @RequestMapping("/get")
    public CulturePalace get(@RequestParam("id") int id) throws SQLException {
        return service.get(id);
    }

    @RequestMapping("/showAll")
    public List<CulturePalace> getAll() throws SQLException {
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") int id) throws SQLException {
        service.delete(id);
    }

    @RequestMapping("/create")
    public CulturePalace create(@RequestBody CulturePalace CulturePalace) throws SQLException {
        return service.insert(CulturePalace);
    }

    @RequestMapping("/update")
    public CulturePalace update(@RequestParam("id") Integer id, @RequestBody CulturePalace CulturePalace) throws SQLException {
            CulturePalace.setId(id);
        return service.update(CulturePalace);
    }

}
