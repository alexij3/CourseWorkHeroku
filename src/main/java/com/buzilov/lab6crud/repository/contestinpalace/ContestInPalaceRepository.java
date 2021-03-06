package com.buzilov.lab6crud.repository.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContestInPalaceRepository extends JpaRepository<ContestInPalace, Integer> {
    @Query("SELECT a FROM ContestInPalace a JOIN a.culturePalace WHERE a.date BETWEEN :firstDate AND :secondDate")
    List<ContestInPalace> findPalacesAndContestsDates(@Param("firstDate")LocalDate firstDate,
                                                              @Param("secondDate") LocalDate secondDate);

    List<ContestInPalace> findAllByDateBetween(@Param("firstDate") LocalDate firstDate, @Param("secondDate") LocalDate secondDate);
    List<ContestInPalace> findAllByDateBetweenAndOrganizerId(@Param("firstDate") LocalDate firstDate,
                                                           @Param("secondDate") LocalDate secondDate,
                                                           @Param("organizerId") int organizerId);
    List<ContestInPalace> findAllByCulturePalaceId(@Param("id") int id);
}

