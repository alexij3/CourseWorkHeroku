package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;

import java.sql.SQLException;
import java.util.List;

public interface ImpresarioService {
    Impresario insert(Impresario impresario) throws SQLException;
    Impresario get(int id) throws SQLException;
    Impresario update(Impresario impresario) throws SQLException;
    Impresario updateGenres(Impresario impresario) throws SQLException;
    void delete(int id) throws SQLException;
    Impresario deleteGenre(Impresario impresario) throws SQLException;
    List<Impresario> getAll() throws SQLException;
    List<Impresario> findAllByGenreSetContaining(Genre genre);
    List<Impresario> findAllByHavingMoreThanOneGenre();
    List<Impresario> findAllByGenreSetIsNull();
    List<Impresario> findAllByAgeLessThan(int age);
    List<Impresario> findAllByAgeGreaterThanEqual(int age);
    List<Impresario> findAllByExperienceLessThan(int experience);
    List<Impresario> findAllByExperienceGreaterThanEqual(int experience);
}
