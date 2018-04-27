/*
package com.buzilov.lab6crud.service.contestresults;

import com.buzilov.lab6crud.dao.contestresults.ContestResultsDAOImpl;
import com.buzilov.lab6crud.model.ContestResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ContestResultsServiceImpl implements ContestResultsService {
    @Autowired
    ContestResultsDAOImpl contestResultsDAO;

    @Override
    public ContestResults insert(ContestResults contest) throws SQLException {
        return contestResultsDAO.insert(contest);
    }

    @Override
    public ContestResults get(int id) throws SQLException {
        return contestResultsDAO.get(id);
    }

    @Override
    public ContestResults update(int oldContestId, int oldArtistId,ContestResults contest) throws SQLException {
        return contestResultsDAO.update(oldContestId, oldArtistId, contest);
    }

    @Override
    public void delete(int contestId, int artistId) throws SQLException {
        contestResultsDAO.delete(contestId, artistId);
    }

    @Override
    public List<ContestResults> getAll() throws SQLException {
        return contestResultsDAO.getAll();
    }
}
*/
