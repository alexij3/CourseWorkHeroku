package com.buzilov.lab6crud.service.contestresults;

import com.buzilov.lab6crud.model.*;
import com.buzilov.lab6crud.repository.contestresults.ContestResultsRepository;
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
public class ContestResultsServiceTest {
    @Mock
    private ContestResultsRepository repository;

    @InjectMocks
    private ContestResultsServiceImpl service;

    private List<ContestResults> contestResultsList;

    private ContestResults contestResultsToCompareWith;

    @Before
    public void setUp() throws Exception {
        contestResultsList = Arrays.asList(
                new ContestResults(new Artist("name 1"), new ContestInPalace(), 1, 'y'),
                new ContestResults(new Artist("name 2"), new ContestInPalace(), 1, 'y'),
                new ContestResults(new Artist("name 3"), new ContestInPalace(), 1, 'y')
        );

        contestResultsToCompareWith =  new ContestResults(new Artist("name 4"), new ContestInPalace(), 1, 'y');

        Mockito.when(repository.findAll()).thenReturn(contestResultsList);
        Mockito.when(repository.save(contestResultsToCompareWith)).thenReturn(contestResultsToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        ContestResults contestResults = service.insert(contestResultsToCompareWith);

        assertEquals(contestResults, contestResultsToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ContestResults expectedContestResults = new ContestResults(new Artist(), new ContestInPalace(), 1, 'y');
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedContestResults));

        ContestResults contestResults = service.get(idToFind);
        Assert.assertEquals(expectedContestResults, contestResults);
    }

    @Test
    public void update() throws Exception {
        ContestResults contestResults = service.update(contestResultsToCompareWith);

        assertEquals(contestResults, contestResultsToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<ContestResults> listToCompareWith = service.getAll();

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

        Mockito.when(repository.findAllByContestId(contestId)).thenReturn(contestResults);

        List<ContestResults> actualResults = service.findAllByContestId(contestId);

        assertEquals(contestResults, actualResults);
    }

}