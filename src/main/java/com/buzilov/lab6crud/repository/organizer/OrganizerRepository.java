package com.buzilov.lab6crud.repository.organizer;

import com.buzilov.lab6crud.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    @Query("SELECT o as counter FROM Organizer o JOIN o.concertInHalls c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndConcertCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

    @Query("SELECT o as counter FROM Organizer o JOIN o.contests c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndContestCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

    @Query("SELECT o as counter FROM Organizer o JOIN o.theatrePerformances c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndTheatreCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

}
