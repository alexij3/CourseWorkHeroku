package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.service.impresario.ImpresarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/impresario")
public class ImpresarioController {
    @Autowired
    ImpresarioServiceImpl service;

    @RequestMapping("/showall")
    public List<Impresario> getAll() throws SQLException  {
        System.out.println(service.getAll());
        return service.getAll();
    }

    @RequestMapping("/delete")
    public void delete(int id) throws SQLException {
        System.out.println("kek");
        service.delete(id);
    }

    @RequestMapping("/deletegenre")
    public void deleteGenre(@RequestParam("impresarioId") int id, @RequestBody Impresario impresario) throws SQLException {
        impresario.setId(id);
        System.out.println(impresario.getGenreSet());
        service.deleteGenre(impresario);
    }

    @RequestMapping("/create")
    public Impresario create(String name) throws SQLException {
        Impresario Impresario = new Impresario(name);
        System.out.println("create impresario " + Impresario);
        return service.insert(Impresario);
    }

    @RequestMapping("/update")
    public Impresario update(@RequestParam("id") Integer id, @RequestBody Impresario Impresario) throws SQLException {
        Impresario.setId(id);
        return service.update(Impresario);
    }

    @RequestMapping("/updategenres")
    public Impresario updateGenres(@RequestParam("id") Integer id, @RequestBody Impresario Impresario) throws SQLException {
        Impresario.setId(id);
        return service.updateGenres(Impresario);
    }

}
