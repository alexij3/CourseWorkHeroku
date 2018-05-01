package com.buzilov.lab6crud.service.contestresults;

import com.buzilov.lab6crud.model.ContestResults;
import com.buzilov.lab6crud.repository.contestresults.ContestResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContestResultsServiceImpl implements ContestResultsService {
    @Autowired
    ContestResultsRepository contestResultsRepository;

    @Override
    public ContestResults insert(ContestResults contest) throws SQLException {
        return contestResultsRepository.save(contest);
    }

    @Override
    public ContestResults get(int id) throws SQLException {
        return contestResultsRepository.findById(id).get();
    }

    @Override
    public ContestResults update(int oldContestId, int oldArtistId, ContestResults contest) throws SQLException {
       // return contestResultsRepository.save(oldContestId, oldArtistId, contest);
        return null;
    }

    @Override
    public void delete(int contestId, int artistId) throws SQLException {
       // contestResultsRepository.deleteBy(contestId, artistId);
    }

    @Override
    public List<ContestResults> getAll() throws SQLException {
        return (List<ContestResults>) contestResultsRepository.findAll();
    }
}
