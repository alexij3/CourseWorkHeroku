package com.buzilov.lab6crud.repository.concertinhall;

import com.buzilov.lab6crud.model.ConcertInHall;
import com.buzilov.lab6crud.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConcertInHallRepository extends JpaRepository<ConcertInHall, Integer> {
    @Query("SELECT a FROM ConcertInHall a JOIN a.concertHall WHERE a.date BETWEEN :firstDate AND :secondDate")
    List<ConcertInHall> findHallsAndConcertsDates(@Param("firstDate")LocalDate firstDate,
                                                      @Param("secondDate") LocalDate secondDate);

    List<ConcertInHall> findAllByDateBetween(@Param("firstDate") LocalDate firstDate, @Param("secondDate") LocalDate secondDate);
    List<ConcertInHall> findAllByDateBetweenAndOrganizerId(@Param("firstDate") LocalDate firstDate,
                                                         @Param("secondDate") LocalDate secondDate,
                                                         @Param("organizerId") int organizerId);
    List<ConcertInHall> findAllByConcertHallId(@Param("id") int id);
}

