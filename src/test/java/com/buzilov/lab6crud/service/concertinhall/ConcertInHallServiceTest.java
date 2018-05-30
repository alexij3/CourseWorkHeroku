package com.buzilov.lab6crud.service.concertinhall;

import com.buzilov.lab6crud.model.ConcertInHall;
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

}