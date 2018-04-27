package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.dao.impresario.ImpresarioDAOImpl;
import com.buzilov.lab6crud.model.Impresario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ImpresarioServiceImpl implements ImpresarioService {
    @Autowired
    ImpresarioDAOImpl impresarioDAO;

    @Override
    public Impresario insert(Impresario impresario) throws SQLException {
        return impresarioDAO.insert(impresario);
    }

    @Override
    public Impresario get(int id) throws SQLException  {
        return impresarioDAO.get(id);
    }

    @Override
    public Impresario update(Impresario impresario) throws SQLException  {
        return impresarioDAO.update(impresario);
    }

    @Override
    public void delete(int id) throws SQLException  {
        impresarioDAO.delete(id);
    }

    @Override
    public List<Impresario> getAll() throws SQLException  {
        return impresarioDAO.getAll();
    }
}
