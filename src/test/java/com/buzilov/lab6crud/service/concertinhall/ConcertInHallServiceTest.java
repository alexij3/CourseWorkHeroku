package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.model.ConcertHall;
import com.buzilov.lab6crud.model.ConcertInHall;
import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.repository.concertinhall.ConcertInHallRepository;
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
public class ConcertInHallServiceTest {
    @Mock
    private ConcertInHallRepository repository;

    @InjectMocks
    private ConcertInHallServiceImpl service;

    private List<ConcertInHall> concertInHallList;

    private ConcertInHall concertInHallToCompareWith;

    @Before
    public void setUp() throws Exception {
        concertInHallList = Arrays.asList(
                new ConcertInHall(null, 0, "Name 1", null, 0, null),
                new ConcertInHall(null, 0, "Name 2", null, 0, null),
                new ConcertInHall(null, 0, "Name 3", null, 0, null)
        );

        concertInHallToCompareWith =  new ConcertInHall(null, 0, "Name 4", null, 0, null);

        Mockito.when(repository.findAll()).thenReturn(concertInHallList);
        Mockito.when(repository.save(concertInHallToCompareWith)).thenReturn(concertInHallToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        ConcertInHall concertInHall = service.insert(concertInHallToCompareWith);

        assertEquals(concertInHall, concertInHallToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ConcertInHall expectedConcertInHall = new ConcertInHall(null, 0, "Name 5", null, 0, null);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedConcertInHall));

        ConcertInHall concertInHall = service.get(idToFind);
        Assert.assertEquals(expectedConcertInHall, concertInHall);
    }

    @Test
    public void update() throws Exception {
        ConcertInHall concertInHall = service.update(concertInHallToCompareWith);

        assertEquals(concertInHall, concertInHallToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<ConcertInHall> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, concertInHallList);
    }

    @Test
    public void findAllByDateBetween() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        ConcertHall concertHall = new ConcertHall("ConcertHall", "address", 50);

        int id = 2;

        concertHall.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ConcertInHall> concertsInHall = Arrays.asList(
                new ConcertInHall(concertHall, id, "Concert 1",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 2",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 3",  organizer, organizerId, date)
        );

        Mockito.when(repository.findAllByDateBetween(firstDate, secondDate)).thenReturn(concertsInHall);

        List<ConcertInHall> actualConcertInHalls = service.findAllByDateBetween(firstDate, secondDate);

        assertEquals(concertsInHall, actualConcertInHalls);
    }

    @Test
    public void findAllByDateBetweenAndOrganizerId() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        ConcertHall concertHall = new ConcertHall("ConcertHall", "address", 50);

        int id = 2;

        concertHall.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ConcertInHall> concertsInHall = Arrays.asList(
                new ConcertInHall(concertHall, id, "Concert 1",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 2",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 3",  organizer, organizerId, date)
        );

        Mockito.when(repository.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId)).thenReturn(concertsInHall);

        List<ConcertInHall> actualConcertInHalls = service.findAllByDateBetweenAndOrganizerId(firstDate, secondDate, organizerId);

        assertEquals(concertsInHall, actualConcertInHalls);
    }

    @Test
    public void findAllByConcertHallId() throws Exception {
        ConcertHall concertHall = new ConcertHall("ConcertHall", "address", 50);

        int id = 2;

        concertHall.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Organizer organizer = new Organizer("Org 1", 25, 5, 5);
        int organizerId = 2;
        organizer.setId(organizerId);

        List<ConcertInHall> concertsInHall = Arrays.asList(
                new ConcertInHall(concertHall, id, "Concert 1",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 2",  organizer, organizerId, date),
                new ConcertInHall(concertHall, id, "Concert 3",  organizer, organizerId, date)
        );

        Mockito.when(repository.findAllByConcertHallId(id)).thenReturn(concertsInHall);

        List<ConcertInHall> actualConcertInHalls = service.findAllByConcertHallId(id);

        assertEquals(concertsInHall, actualConcertInHalls);
    }

}