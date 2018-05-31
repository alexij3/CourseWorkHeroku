package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.service.theatre.TheatreServiceImpl;
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
public class TheatreControllerTest {
    @Mock
    private TheatreServiceImpl service;

    @InjectMocks
    private TheatreController controller;

    private List<Theatre> theatreList;

    private Theatre theatreToCompareWith;

    @Before
    public void setUp() throws Exception {
        theatreList = Arrays.asList(
                new Theatre("Name 1", "Add 1", 10),
                new Theatre("Name 2", "Add 2", 10),
                new Theatre("Name 3", "Add 3", 10),
                new Theatre("Name 4", "Add 4", 10)
        );

        theatreToCompareWith = new Theatre("Name 5", "Add 5", 10);
        theatreToCompareWith.setId(1);

        Mockito.when(service.getAll()).thenReturn(theatreList);
        Mockito.when(service.insert(theatreToCompareWith)).thenReturn(theatreToCompareWith);
        Mockito.when(service.update(theatreToCompareWith)).thenReturn(theatreToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        Theatre theatre = controller.create(theatreToCompareWith);

        assertEquals(theatre, theatreToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        Theatre expectedTheatre = new Theatre("Some", "some", 10);
        Mockito.when(service.get(idToFind)).thenReturn(expectedTheatre);

        Theatre theatre = controller.get(idToFind);
        Assert.assertEquals(expectedTheatre, theatre);
    }

    @Test
    public void update() throws Exception {
        Theatre theatre = controller.update(theatreToCompareWith.getId(), theatreToCompareWith);

        assertEquals(theatre, theatreToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<Theatre> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, theatreList);
    }

    @Test
    public void findAllByCapacityGreaterThanEqual() throws Exception {
        List<Theatre> theatres = Arrays.asList(
                new Theatre("Theatre 1", "Add 1", 60),
                new Theatre("Theatre 2", "Add 2", 70),
                new Theatre("Theatre 3", "Add 3", 80)
        );

        int capacity = 50;

        Mockito.when(service.findAllByCapacityGreaterThanEqual(capacity)).thenReturn(theatres);

        List<Theatre> actualTheatres = controller.findAllByCapacityGreaterThanEqual(capacity);

        assertEquals(theatres, actualTheatres);

    }
}