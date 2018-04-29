package com.buzilov.lab6crud.repository.concerthall;

import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertHallRepository extends CrudRepository<ConcertHall, Integer> {

}
