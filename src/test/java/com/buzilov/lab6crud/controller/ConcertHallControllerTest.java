package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.ConcertHall;
import com.buzilov.lab6crud.service.concerthall.ConcertHallServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ConcertHallControllerTest {
    @Mock
    private ConcertHallServiceImpl service;

    @InjectMocks
    private ConcertHallController controller;

    private List<ConcertHall> concertHallList;

    private ConcertHall concertHallToCompareWith;

    @Before
    public void setUp() throws Exception {
        concertHallList = Arrays.asList(
                new ConcertHall("Name 1", "Address 1", 10),
                new ConcertHall("Name 2", "Address 2", 10),
                new ConcertHall("Name 3", "Address 3", 10)
        );

        concertHallToCompareWith =  new ConcertHall("Name 4", "Address 4", 10);
        concertHallToCompareWith.setId(1);

        Mockito.when(service.getAll()).thenReturn(concertHallList);
        Mockito.when(service.insert(concertHallToCompareWith)).thenReturn(concertHallToCompareWith);
        Mockito.when(service.update(concertHallToCompareWith)).thenReturn(concertHallToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        ConcertHall concertHall = controller.create(concertHallToCompareWith);

        assertEquals(concertHall, concertHallToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ConcertHall expectedConcertHall = new ConcertHall("Some", "some", 10);
        Mockito.when(service.get(idToFind)).thenReturn(expectedConcertHall);

        ConcertHall artist = controller.get(idToFind);
        Assert.assertEquals(expectedConcertHall, artist);
    }

    @Test
    public void update() throws Exception {
        ConcertHall concertHall = controller.update(concertHallToCompareWith.getId(), concertHallToCompareWith);

        assertEquals(concertHall, concertHallToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<ConcertHall> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, concertHallList);
    }

    @Test
    public void findAllByCapacityGreaterThanEqual() throws Exception {
        List<ConcertHall> concertHalls = Arrays.asList(
                new ConcertHall("ConcertHall 1", "Add 1", 60),
                new ConcertHall("ConcertHall 2", "Add 2", 70),
                new ConcertHall("ConcertHall 3", "Add 3", 80)
        );

        int capacity = 50;

        Mockito.when(service.findAllByCapacityGreaterThanEqual(capacity)).thenReturn(concertHalls);

        List<ConcertHall> actualConcertHalls = controller.findAllByCapacityGreaterThanEqual(capacity);

        assertEquals(concertHalls, actualConcertHalls);

    }
}