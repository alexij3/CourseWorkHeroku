package com.buzilov.lab6crud.repository.contestresults;

import com.buzilov.lab6crud.model.ContestResults;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestResultsRepository extends CrudRepository<ContestResults, Integer>{
    List<ContestResults> findAllByContestId(@Param("contestId") int contestId);

}

