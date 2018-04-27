package com.buzilov.lab6crud.dao.concerthall;

import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ConcertHallDAO extends CrudRepository<ConcertHall, Integer> {

}
