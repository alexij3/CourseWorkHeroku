package com.buzilov.lab6crud.service.impresariogenre;

import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.ImpresarioGenre;

import java.sql.SQLException;
import java.util.List;

public interface ImpresarioGenreService {
    ImpresarioGenre get(int id) throws SQLException;
    ImpresarioGenre update(String oldGenre, ImpresarioGenre impresarioGenre) throws SQLException;
    void delete(int id, Genre genre) throws SQLException;
    ImpresarioGenre insert(ImpresarioGenre impresarioGenre) throws SQLException;
    List<ImpresarioGenre> getAll() throws SQLException;
}
