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
        /*contestResults.setArtist(artistService.getArtist(artistId));
        contestResults.setContest(contestInPalaceService.get(contestId));
        System.out.println(contestResults.getArtist() + " - ARTIST");
        System.out.println(contestResults.getContest() + " - CONTEST");
        System.out.println(contestResults + " - CONTEST RESULTS");*/

        Artist artist = artistService.getArtist(artistId);

        ContestResults contestResults = new ContestResults();
        contestResults.setArtist(artist);
        contestResults.setContest(contestInPalaceService.get(contestId));
        contestResults.setPlace(place);
        contestResults.setIsWinner(isWinner);

        artist.getContestResults().add(contestResults);

        artistService.updateArtist(artist);

        return null;
    }

    @RequestMapping("/update")
    public ContestResults update(@RequestParam("oldContestId") int oldContestId,
                                 @RequestParam("oldArtistId") int oldArtistId,
                                 @RequestParam("contestId") int contestId,
                                 @RequestParam("artistId") int artistId,
                                 @RequestParam("place") int place,
                                 @RequestParam("isWinner") char isWinner) throws SQLException {
        Artist oldArtist = artistService.getArtist(oldArtistId);
        Artist newArtist = artistService.getArtist(artistId);

        ContestInPalace oldContest = contestInPalaceService.get(oldContestId);
        ContestInPalace newContest = contestInPalaceService.get(contestId);

        ContestResults oldContestResults = new ContestResults();
        oldContestResults.setArtist(oldArtist);
        oldContestResults.setContest(oldContest);
        oldContestResults.setPlace(place);
        oldContestResults.setIsWinner(isWinner);

        ContestResults newContestResults = new ContestResults();
        newContestResults.setArtist(newArtist);
        newContestResults.setContest(newContest);
        newContestResults.setPlace(place);
        newContestResults.setIsWinner(isWinner);

        oldArtist.getContestResults().remove(oldContestResults);
        newArtist.getContestResults().add(newContestResults);

        artistService.updateArtist(newArtist);


        return null;
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("contestId") int contestId, @RequestParam("artistId") int artistId) throws SQLException {
        Artist artist = artistService.getArtist(artistId);
        ContestInPalace contest = contestInPalaceService.get(contestId);

        ContestResults contestResults = artist.getContestResults().stream().filter(el->el.getContest() == contest).findFirst().get();
        System.out.println(artist.getContestResults().size());
        System.out.println("RES ARTIST: " + contestResults.getArtist());
        System.out.println("RES CONTEST: " + contestResults.getContest());
        System.out.println(artist.getContestResults().remove(contestResults));
        System.out.println(artist.getContestResults().size());
        System.out.println(artistService.updateArtist(artist).getContestResults().size());
    }
}