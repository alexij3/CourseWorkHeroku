package com.buzilov.lab6crud.repository.concerthall;

import com.buzilov.lab6crud.model.ConcertHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertHallRepository extends JpaRepository<ConcertHall, Integer> {
    List<ConcertHall> findAllByCapacityGreaterThanEqual(@Param("capacity") int capacity);
}
