package com.buzilov.lab6crud.repository.theatreperformance;

import com.buzilov.lab6crud.model.TheatrePerformance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatrePerformanceRepository extends CrudRepository<TheatrePerformance, Integer> {

}
