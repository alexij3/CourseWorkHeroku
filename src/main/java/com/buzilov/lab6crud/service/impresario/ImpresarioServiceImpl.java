package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.dao.impresario.ImpresarioDAO;
import com.buzilov.lab6crud.model.Impresario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ImpresarioServiceImpl implements ImpresarioService {
    @Autowired
    ImpresarioDAO impresarioDAO;

    @Override
    public Impresario insert(Impresario impresario) throws SQLException {
        return impresarioDAO.save(impresario);
    }

    @Override
    public Impresario get(int id) throws SQLException  {
        return impresarioDAO.findById(id).get();
    }

    @Override
    public Impresario update(Impresario impresario) throws SQLException  {
        Impresario updatedImpresario = get(impresario.getId());
        updatedImpresario.getGenreSet().addAll(impresario.getGenreSet());
        return impresarioDAO.save(updatedImpresario);
    }

    @Override
    public void delete(int id) throws SQLException  {
        impresarioDAO.deleteById(id);
    }

    @Override
    public List<Impresario> getAll() throws SQLException  {
        return (List<Impresario>) impresarioDAO.findAll();
    }

    @Override
    public Impresario deleteGenre(Impresario impresario) throws SQLException {
        Impresario updatedImpresario = impresarioDAO.findById(impresario.getId()).get();
        updatedImpresario.getGenreSet().removeAll(impresario.getGenreSet());
        return impresarioDAO.save(updatedImpresario);
    }
}
