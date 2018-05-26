package com.buzilov.lab6crud.repository.organizer;

import com.buzilov.lab6crud.model.Organizer;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {
    @Query("SELECT o as counter FROM Organizer o JOIN o.concertInHalls c WHERE c.date BETWEEN :firstDate AND :secondDate")
    List<Organizer> findAllAndConcertCount(@Param("firstDate")LocalDate firstDate,
                                           @Param("secondDate") LocalDate secondDate);
}
