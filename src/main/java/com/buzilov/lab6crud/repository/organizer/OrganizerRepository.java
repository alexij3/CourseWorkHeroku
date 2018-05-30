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
    @Query("SELECT DISTINCT NEW Organizer(o.id, o.name, o.age, o.experience, COUNT(o)) FROM Organizer o JOIN o.concertInHalls c WHERE c.date BETWEEN :firstDate AND :secondDate GROUP BY o.id")
    List<Organizer> findAllAndConcertCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

    @Query("SELECT DISTINCT o as counter FROM Organizer o JOIN o.contests c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndContestCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

    @Query("SELECT DISTINCT o as counter FROM Organizer o JOIN o.theatrePerformances c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndTheatreCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);

    List<Organizer> findAllByAgeLessThan(@Param("age") int age);
    List<Organizer> findAllByAgeGreaterThanEqual(@Param("age") int age);
    List<Organizer> findAllByExperienceLessThan(@Param("experience") int experience);
    List<Organizer> findAllByExperienceGreaterThanEqual(@Param("experience") int experience);

}
