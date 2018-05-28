package com.buzilov.lab6crud.repository.culturepalace;

import com.buzilov.lab6crud.model.CulturePalace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CulturePalaceRepository extends JpaRepository<CulturePalace, Integer> {
    List<CulturePalace> findAllByCapacityGreaterThanEqual(@Param("capacity") int capacity);
}
