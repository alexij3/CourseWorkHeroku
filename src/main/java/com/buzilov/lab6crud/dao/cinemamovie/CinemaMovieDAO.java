package com.buzilov.lab6crud.dao.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaMovieDAO extends CrudRepository<CinemaMovie, Integer> {

}

