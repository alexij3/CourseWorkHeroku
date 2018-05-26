package com.buzilov.lab6crud.repository.theatreperformance;

import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.model.TheatrePerformance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TheatrePerformanceRepository extends CrudRepository<TheatrePerformance, Integer> {
    @Query("SELECT a FROM TheatrePerformance a JOIN a.theatre WHERE a.date BETWEEN :firstDate AND :secondDate")
    List<TheatrePerformance> findTheatresAndPerformancesDates(@Param("firstDate")LocalDate firstDate,
                                                              @Param("secondDate") LocalDate secondDate);
}
