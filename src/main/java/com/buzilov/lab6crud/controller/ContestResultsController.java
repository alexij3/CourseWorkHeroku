/*
package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ContestResults;
import com.buzilov.lab6crud.service.contestresults.ContestResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/contestresults")
public class ContestResultsController {
    @Autowired
    ContestResultsServiceImpl contestResultsService;

    @RequestMapping("/showall")
    public List<ContestResults> showContestResults() throws SQLException {
        return contestResultsService.getAll();
    }

    @RequestMapping("/insert")
    public ContestResults insert(@RequestBody ContestResults contestResults) throws SQLException {
        return contestResultsService.insert(contestResults);
    }

    @RequestMapping("/update")
    public ContestResults update(@RequestParam("oldContestId") int oldContestId,
                                 @RequestParam("oldArtistId") int oldArtistId,
                                 @RequestBody ContestResults contestResults) throws SQLException {
        return contestResultsService.update(oldContestId, oldArtistId, contestResults);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("contestId") int contestId, @RequestParam("artistId") int artistId) throws SQLException {
        contestResultsService.delete(contestId, artistId);
    }

}
*/
