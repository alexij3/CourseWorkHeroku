package com.buzilov.lab6crud.repository.theatre;

import com.buzilov.lab6crud.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findAllByCapacityGreaterThanEqual(@Param("capacity") int capacity);
}
