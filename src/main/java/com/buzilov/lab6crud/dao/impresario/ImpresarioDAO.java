package com.buzilov.lab6crud.dao.impresario;

import com.buzilov.lab6crud.model.Impresario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ImpresarioDAO extends CrudRepository<Impresario, Integer> {

}
