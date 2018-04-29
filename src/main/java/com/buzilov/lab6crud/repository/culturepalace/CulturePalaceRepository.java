package com.buzilov.lab6crud.repository.culturepalace;

import com.buzilov.lab6crud.model.CulturePalace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturePalaceRepository extends CrudRepository<CulturePalace, Integer> {

}
