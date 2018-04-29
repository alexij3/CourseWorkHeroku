package com.buzilov.lab6crud.repository.cinema;

import com.buzilov.lab6crud.model.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

}
