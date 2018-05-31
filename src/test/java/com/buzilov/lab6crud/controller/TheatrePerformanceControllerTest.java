package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.model.TheatrePerformance;
import com.buzilov.lab6crud.service.theatreperformance.TheatrePerformanceServiceImpl;
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
public class TheatrePerformanceControllerTest {
    @Mock
    private TheatrePerformanceServiceImpl service;

    @InjectMocks
    private TheatrePerformanceController controller;

    private List<TheatrePerformance> theatrePerformanceList;

    private TheatrePerformance theatrePerformanceToCompareWith;

    @Before
    public void setUp() throws Exception {
        theatrePerformanceList = Arrays.asList(
                new TheatrePerformance(null, 0, "Name 1", null, 0, null),
                new TheatrePerformance(null, 0, "Name 2", null, 0, null),
                new TheatrePerformance(null, 0, "Name 3", null, 0, null)
        );

        theatrePerformanceToCompareWith =  new TheatrePerformance(null, 0, "Name 4", null, 0, null);

        Mockito.when(service.getAll()).thenReturn(theatrePerformanceList);
        Mockito.when(service.insert(theatrePerformanceToCompareWith)).thenReturn(theatrePerformanceToCompareWith);
        Mockito.when(service.update(theatrePerformanceToCompareWith)).thenReturn(theatrePerformanceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        TheatrePerformance theatrePerformance = controller.insert(theatrePerformanceToCompareWith);

        assertEquals(theatrePerformance, theatrePerformanceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        TheatrePerformance expectedTheatrePerformance = new TheatrePerformance(null, 0, "Name 5", null, 0, null);
        Mockito.when(service.get(idToFind)).thenReturn(expectedTheatrePerformance);

        TheatrePerformance theatrePerformance = controller.get(idToFind);
        Assert.assertEquals(expectedTheatrePerformance, theatrePerformance);
    }

    @Test
    public void update() throws Exception {
        TheatrePerformance theatrePerformance = controller.update(theatrePerformanceToCompareWith);

        assertEquals(theatrePerformance, theatrePerformanceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<TheatrePerformance> listToCompareWith = controller.show();

        assertEquals(listToCompareWith, theatrePerformanceList);
    }

    @Test
    public void findAllByDateBetween() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        Theatre theatre = new Theatre("Theatre", "address", 50);

        int id = 2;

        theatre.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<TheatrePerformance> theatrePerformances = Arrays.asList(
                new TheatrePerformance(theatre, id, "Performance 1",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 2",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByDateBetween(firstDate, secondDate)).thenReturn(theatrePerformances);

        List<TheatrePerformance> actualTheatrePerformances = controller.findAllByDateBetween(firstDate.toString(), secondDate.toString());

        assertEquals(theatrePerformances, actualTheatrePerformances);
    }

    @Test
    public void findAllByDateBetweenAndOrganizerId() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        Theatre theatre = new Theatre("Theatre", "address", 50);

        int id = 2;

        theatre.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<TheatrePerformance> theatrePerformances = Arrays.asList(
                new TheatrePerformance(theatre, id, "Performance 1",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 2",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId)).thenReturn(theatrePerformances);

        List<TheatrePerformance> actualTheatrePerformances = controller.findAllByDateBetweenAndOrganizer(firstDate.toString(), secondDate.toString(), organizerId);

        assertEquals(theatrePerformances, actualTheatrePerformances);
    }

    @Test
    public void findAllByTheatreId() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        Theatre theatre = new Theatre("Theatre", "address", 50);

        int id = 2;

        theatre.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<TheatrePerformance> theatrePerformances = Arrays.asList(
                new TheatrePerformance(theatre, id, "Performance 1",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 2",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 3",  organizer, organizerId, date)
        );

        Mockito.when(service.findAllByTheatreId(id)).thenReturn(theatrePerformances);

        List<TheatrePerformance> actualTheatrePerformances = controller.findAllByTheatreId(id);

        assertEquals(theatrePerformances, actualTheatrePerformances);
    }

    @Test
    public void findTheatresAndPerformancesDates() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 17);

        Theatre theatre = new Theatre("Theatre", "address", 50);

        int id = 2;

        theatre.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);
        LocalDate date1 = LocalDate.of(2018, 4, 15);
        LocalDate date2 = LocalDate.of(2018, 4, 17);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<TheatrePerformance> theatrePerformances = Arrays.asList(
                new TheatrePerformance(theatre, id, "Performance 1",  organizer, organizerId, date),
                new TheatrePerformance(theatre, id, "Performance 2",  organizer, organizerId, date1),
                new TheatrePerformance(theatre, id, "Performance 3",  organizer, organizerId, date2)
        );

        Mockito.when(service.findTheatresAndPerformancesDates(firstDate, secondDate)).thenReturn(theatrePerformances);

        List<TheatrePerformance> actualTheatrePerformances = controller.findTheatresAndPerformancesDates(firstDate.toString(), secondDate.toString());

        assertEquals(theatrePerformances, actualTheatrePerformances);
    }
}