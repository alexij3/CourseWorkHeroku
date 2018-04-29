package com.buzilov.lab6crud.dao.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestInPalaceDAO extends CrudRepository<ContestInPalace, Integer>{

}

