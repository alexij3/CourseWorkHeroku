package com.buzilov.lab6crud.dao.theatre;

import com.buzilov.lab6crud.model.Theatre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface TheatreDAO extends CrudRepository<Theatre, Integer> {

}
