package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.*;
import com.buzilov.lab6crud.service.contestresults.ContestResultsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ContestResultsControllerTest {
    @Mock
    private ContestResultsServiceImpl service;

    @InjectMocks
    private ContestResultsController controller;

    private List<ContestResults> contestResultsList;

    private ContestResults contestResultsToCompareWith;

    @Before
    public void setUp() throws Exception {
        contestResultsList = Arrays.asList(
                new ContestResults(new Artist("name 1"), new ContestInPalace(), 1, 'y'),
                new ContestResults(new Artist("name 2"), new ContestInPalace(), 1, 'y'),
                new ContestResults(new Artist("name 3"), new ContestInPalace(), 1, 'y')
        );

        Artist artist = new Artist("Artist");
        int artistId = 1;
        artist.setId(artistId);

        ContestInPalace contest = new ContestInPalace(null, 0, "Palace", null, 0, null);
        int contestId = 1;
        contest.setId(1);

        int place = 1;
        char winner = 'y';


        contestResultsToCompareWith = new ContestResults(artist, contest, place, winner);

        Mockito.when(service.getAll()).thenReturn(contestResultsList);
        Mockito.when(service.insert(contestResultsToCompareWith)).thenReturn(contestResultsToCompareWith);
        Mockito.when(service.update(contestResultsToCompareWith)).thenReturn(contestResultsToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ContestResults expectedContestResults = new ContestResults(new Artist(), new ContestInPalace(), 1, 'y');
        Mockito.when(service.get(idToFind)).thenReturn(expectedContestResults);

        ContestResults contestResults = controller.get(idToFind);
        Assert.assertEquals(expectedContestResults, contestResults);
    }

    @Test
    public void getAll() throws Exception {
        List<ContestResults> listToCompareWith = controller.showContestResults();

        assertEquals(listToCompareWith, contestResultsList);
    }

    @Test
    public void findAllByContestId() throws Exception {
        CulturePalace culturePalace = new CulturePalace("Palace", "Address", 100);

        int palaceId = 2;
        culturePalace.setId(palaceId);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        ContestInPalace contest = new ContestInPalace(culturePalace, palaceId, "Contest", organizer, organizerId, date);
        int contestId = 1;
        contest.setId(contestId);

        List<ContestResults> contestResults = Arrays.asList(
                new ContestResults(new Artist("name 1"), contest, 1, 'y'),
                new ContestResults(new Artist("name 2"), contest, 2, 'y'),
                new ContestResults(new Artist("name 3"), contest, 3, 'y')
        );

        Mockito.when(service.findAllByContestId(contestId)).thenReturn(contestResults);

        List<ContestResults> actualResults = controller.findAllByContestId(contestId);

        assertEquals(contestResults, actualResults);
    }
}