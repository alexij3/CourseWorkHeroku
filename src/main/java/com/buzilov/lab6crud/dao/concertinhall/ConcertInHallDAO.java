package com.buzilov.lab6crud.dao.concertinhall;

import com.buzilov.lab6crud.model.ConcertInHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertInHallDAO extends CrudRepository<ConcertInHall, Integer>{

}

