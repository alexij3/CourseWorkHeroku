package com.buzilov.lab6crud.repository.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaMovieRepository extends CrudRepository<CinemaMovie, Integer> {

}

