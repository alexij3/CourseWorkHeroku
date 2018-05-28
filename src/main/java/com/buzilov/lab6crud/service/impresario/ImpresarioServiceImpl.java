package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.repository.impresario.ImpresarioRepository;
import com.buzilov.lab6crud.model.Impresario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImpresarioServiceImpl implements ImpresarioService {
    @Autowired
    ImpresarioRepository impresarioRepository;

    @Override
    public Impresario insert(Impresario impresario) throws SQLException {
        return impresarioRepository.save(impresario);
    }

    @Override
    public Impresario update(Impresario impresario) throws SQLException {
        return impresarioRepository.save(impresario);
    }

    @Override
    public Impresario get(int id) throws SQLException  {
        return impresarioRepository.findById(id).get();
    }

    @Override
    public Impresario updateGenres(Impresario impresario) throws SQLException  {
        Impresario updatedImpresario = get(impresario.getId());
        updatedImpresario.getGenreSet().addAll(impresario.getGenreSet());
        return impresarioRepository.save(updatedImpresario);
    }

    @Override
    public void delete(int id) throws SQLException  {
        impresarioRepository.deleteById(id);
    }

    @Override
    public List<Impresario> getAll() throws SQLException  {
        return (List<Impresario>) impresarioRepository.findAll();
    }

    @Override
    public Impresario deleteGenre(Impresario impresario) throws SQLException {
        Impresario updatedImpresario = impresarioRepository.findById(impresario.getId()).get();
        updatedImpresario.getGenreSet().removeAll(impresario.getGenreSet());
        return impresarioRepository.save(updatedImpresario);
    }

    @Override
    public List<Impresario> findAllByGenreSetContaining(Genre genre) {
        return impresarioRepository.findAllByGenreSetContaining(genre);
    }

    @Override
    public List<Impresario> findAllByHavingMoreThanOneGenre() {
        List<Impresario> impresarios = impresarioRepository.findAll();
        List<Impresario> listToShow = new ArrayList<>();

        for (Impresario a : impresarios)
            if (a.getGenreSet().size() > 1) listToShow.add(a);

        return listToShow;
    }
}
