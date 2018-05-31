package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ContestInPalace;
import com.buzilov.lab6crud.model.CulturePalace;
import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.service.contestinpalace.ContestInPalaceServiceImpl;
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
public class ContestInPalaceControllerTest {
    @Mock
    private ContestInPalaceServiceImpl service;

    @InjectMocks
    private ContestInPalaceController controller;

    private List<ContestInPalace> contestInPalaceList;

    private ContestInPalace contestInPalaceToCompareWith;

    @Before
    public void setUp() throws Exception {
        contestInPalaceList = Arrays.asList(
                new ContestInPalace(null, 0, "Name 1", null, 0, null),
                new ContestInPalace(null, 0, "Name 2", null, 0, null),
                new ContestInPalace(null, 0, "Name 3", null, 0, null)
        );

        contestInPalaceToCompareWith =  new ContestInPalace(null, 0, "Name 4", null, 0, null);

        Mockito.when(service.getAll()).thenReturn(contestInPalaceList);
        Mockito.when(service.insert(contestInPalaceToCompareWith)).thenReturn(contestInPalaceToCompareWith);
        Mockito.when(service.update(contestInPalaceToCompareWith)).thenReturn(contestInPalaceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        ContestInPalace contestInPalace = controller.insert(contestInPalaceToCompareWith);

        assertEquals(contestInPalace, contestInPalaceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ContestInPalace expectedContestInPalace = new ContestInPalace(null, 0, "Name 5", null, 0, null);
        Mockito.when(service.get(idToFind)).thenReturn(expectedContestInPalace);

        ContestInPalace contestInPalace = controller.get(idToFind);
        Assert.assertEquals(expectedContestInPalace, contestInPalace);
    }

    @Test
    public void update() throws Exception {
        ContestInPalace contestInPalace = controller.update(contestInPalaceToCompareWith);

        assertEquals(contestInPalace, contestInPalaceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<ContestInPalace> listToCompareWith = controller.showContestsInPalaces();

        assertEquals(listToCompareWith, contestInPalaceList);
    }

    @Test
    public void findAllByDateBetween() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        CulturePalace culturePalace = new CulturePalace("CulturePalace", "address", 50);

        int id = 2;

        culturePalace.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ContestInPalace> contestInPalaces = Arrays.asList(
                new ContestInPalace(culturePalace, id, "Contest 1",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 2",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByDateBetween(firstDate, secondDate)).thenReturn(contestInPalaces);

        List<ContestInPalace> actualContestInPalaces = controller.findAllByDateBetween(firstDate.toString(), secondDate.toString());

        assertEquals(contestInPalaces, actualContestInPalaces);
    }

    @Test
    public void findAllByDateBetweenAndOrganizerId() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        CulturePalace culturePalace = new CulturePalace("CulturePalace", "address", 50);

        int id = 2;

        culturePalace.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ContestInPalace> contestInPalaces = Arrays.asList(
                new ContestInPalace(culturePalace, id, "Contest 1",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 2",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId)).thenReturn(contestInPalaces);

        List<ContestInPalace> actualContestInPalaces = controller.findAllByDateBetweenAndOrganizer(firstDate.toString(), secondDate.toString(), organizerId);

        assertEquals(contestInPalaces, actualContestInPalaces);
    }

    @Test
    public void findAllByCulturePalaceId() throws Exception {
        CulturePalace culturePalace = new CulturePalace("CulturePalace", "address", 50);

        int id = 2;

        culturePalace.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ContestInPalace> contestInPalaces = Arrays.asList(
                new ContestInPalace(culturePalace, id, "Contest 1",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 2",  organizer, organizerId, date),
                new ContestInPalace(culturePalace, id, "Contest 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByCulturePalaceId(id)).thenReturn(contestInPalaces);

        List<ContestInPalace> actualContestInPalaces = controller.findAllByCulturePalaceId(id);

        assertEquals(contestInPalaces, actualContestInPalaces);
    }
}