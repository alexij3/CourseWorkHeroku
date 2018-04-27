/*
package com.buzilov.lab6crud.service.artistandimpresario;

import com.buzilov.lab6crud.dao.artistandimpresario.ArtistAndImpresarioDAOImpl;
import com.buzilov.lab6crud.model.ArtistAndImpresario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArtistAndImpresarioServiceImpl implements ArtistAndImpresarioService {
    @Autowired
    ArtistAndImpresarioDAOImpl artistAndImpresarioDAO;

    @Override
    public ArtistAndImpresario insert(ArtistAndImpresario artistAndImpresario) throws SQLException {
        return artistAndImpresarioDAO.insert(artistAndImpresario);
    }

    @Override
    public ArtistAndImpresario get(int id) throws SQLException {
        return artistAndImpresarioDAO.get(id);
    }

    @Override
    public ArtistAndImpresario update(int oldImpresarioId, ArtistAndImpresario artistAndImpresario) throws SQLException {
        return artistAndImpresarioDAO.update(oldImpresarioId, artistAndImpresario);
    }

    @Override
    public void delete(int id, int impresarioId) throws SQLException {
        artistAndImpresarioDAO.delete(id, impresarioId);
    }

    @Override
    public List<ArtistAndImpresario> getAll() throws SQLException {
        return artistAndImpresarioDAO.getAll();
    }
}
*/
