package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Genre;
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
    public Impresario create(@RequestBody Impresario impresario) throws SQLException {
        return service.insert(impresario);
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

    @RequestMapping("/findAllByGenreSetContaining")
    public List<Impresario> findAllByGenreSetContaining(@RequestParam("genre") Genre genre){
        return service.findAllByGenreSetContaining(genre);
    }

    @RequestMapping("/findAllByHavingMoreThanOneGenre")
    public List<Impresario> findAllByHavingMoreThanOneGenre(){
        return service.findAllByHavingMoreThanOneGenre();
    }

    @RequestMapping("/findAllByGenreSetIsNull")
    public List<Impresario> findAllByGenreSetIsNull(){
        return service.findAllByGenreSetIsNull();
    }

    @RequestMapping("/findAllByAgeLessThan")
    public List<Impresario> findAllByAgeLessThan(int age) {
        return service.findAllByAgeLessThan(age);
    }

    @RequestMapping("/findAllByAgeGreaterThanEqual")
    public List<Impresario> findAllByAgeGreaterThanEqual(int age) {
        return service.findAllByAgeGreaterThanEqual(age);
    }

    @RequestMapping("/findAllByExperienceLessThan")
    public List<Impresario> findAllByExperienceLessThan(int experience) {
        return service.findAllByExperienceLessThan(experience);
    }

    @RequestMapping("/findAllByExperienceGreaterThanEqual")
    public List<Impresario> findAllByExperienceGreaterThanEqual(int experience) {
        return service.findAllByExperienceGreaterThanEqual(experience);
    }

    @RequestMapping("/get")
    public Impresario get(@RequestParam("id") int id) throws SQLException{
        return service.get(id);
    }
}
