package com.buzilov.lab6crud.dao.artistandimpresario;

import com.buzilov.lab6crud.model.ArtistAndImpresario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ArtistAndImpresarioDAO extends CrudRepository<ArtistAndImpresario, Integer> {

}
