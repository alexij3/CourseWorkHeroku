package com.buzilov.lab6crud.repository.contestresults;

import com.buzilov.lab6crud.model.ContestResults;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestResultsRepository extends CrudRepository<ContestResults, Integer>{

}

