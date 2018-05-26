package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.ContestInPalace;
import com.buzilov.lab6crud.model.ContestResults;
import com.buzilov.lab6crud.service.artist.ArtistServiceImpl;
import com.buzilov.lab6crud.service.contestinpalace.ContestInPalaceServiceImpl;
import com.buzilov.lab6crud.service.contestresults.ContestResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/contestresults")
public class ContestResultsController {
    @Autowired
    ContestResultsServiceImpl contestResultsService;

    @Autowired
    ArtistServiceImpl artistService;

    @Autowired
    ContestInPalaceServiceImpl contestInPalaceService;

    @RequestMapping("/showall")
    public List<ContestResults> showContestResults() throws SQLException {
        return contestResultsService.getAll();
    }

    @RequestMapping("/insert")
    public ContestResults insert(@RequestParam("artistId") int artistId,
                                 @RequestParam("contestId") int contestId,
                                 @RequestParam("place") int place,
                                 @RequestParam("isWinner") char isWinner) throws SQLException {
        Artist artist = new Artist();
        artist.setId(artistId);
        ContestInPalace contest = new ContestInPalace();
        contest.setId(contestId);
        ContestResults contestResults = new ContestResults(artist, contest, place, isWinner);

        return contestResultsService.insert(contestResults);
    }

    @RequestMapping("/update")
    public ContestResults update(@RequestParam("contestResultId") int contestResultId,
                                 @RequestParam("contestId") int contestId,
                                 @RequestParam("artistId") int artistId,
                                 @RequestParam("place") int place,
                                 @RequestParam("isWinner") char isWinner) throws SQLException {

        ContestInPalace contest = new ContestInPalace();
        contest.setId(contestId);

        Artist artist = new Artist();
        artist.setId(artistId);

        ContestResults contestResults = new ContestResults(artist, contest, place, isWinner);
        contestResults.setId(contestResultId);

        return contestResultsService.update(contestResults);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("contestResultId") int contestResultId) throws SQLException {
        contestResultsService.delete(contestResultId);
    }

    @RequestMapping("/findAllByContestId")
    public List<ContestResults> findAllByContestId(@RequestParam("contestId") int contestId){
        return contestResultsService.findAllByContestId(contestId);
    }
}