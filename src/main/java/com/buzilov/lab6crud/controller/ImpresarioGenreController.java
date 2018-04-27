/*
package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ImpresarioGenre;
import com.buzilov.lab6crud.service.impresario.ImpresarioServiceImpl;
import com.buzilov.lab6crud.service.impresariogenre.ImpresarioGenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/impresariogenre")
public class ImpresarioGenreController {
    @Autowired
    ImpresarioServiceImpl impresarioService;

    @Autowired
    ImpresarioGenreServiceImpl impresarioGenreService;

    @RequestMapping("/showgenres")
    public List<ImpresarioGenre> showGenres() throws SQLException {
        return impresarioGenreService.getAll();
    }

    @RequestMapping("/insertgenre")
    public ImpresarioGenre insertGenre(@RequestParam("id") int id, @RequestBody ImpresarioGenre impresarioGenre) throws SQLException{
        impresarioGenre.setImpresarioId(id);
        return impresarioGenreService.insert(impresarioGenre);
    }

    @RequestMapping("/deletegenre")
    public void deleteGenre(@RequestParam("id") int id, @RequestBody ImpresarioGenre impresarioGenre) throws SQLException {
        impresarioGenreService.delete(id, impresarioGenre.getGenre());
    }

    @RequestMapping("/updategenre")
    public ImpresarioGenre updateGenre(@RequestParam("oldGenre") String oldGenre, @RequestBody ImpresarioGenre impresarioGenre) throws SQLException{
        System.out.println(impresarioGenre);
        return impresarioGenreService.update(oldGenre, impresarioGenre);
    }
}
*/
