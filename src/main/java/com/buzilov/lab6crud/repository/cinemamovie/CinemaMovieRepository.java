package com.buzilov.lab6crud.repository.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaMovieRepository extends JpaRepository<CinemaMovie, Integer> {
    List<CinemaMovie> findAllByCinemaId(@Param("id") int id);
}

