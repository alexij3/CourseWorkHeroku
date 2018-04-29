package com.buzilov.lab6crud.repository.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestInPalaceRepository extends CrudRepository<ContestInPalace, Integer>{

}

