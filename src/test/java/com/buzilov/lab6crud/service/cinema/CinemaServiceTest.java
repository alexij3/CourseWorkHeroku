package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.model.Cinema;
import com.buzilov.lab6crud.repository.cinema.CinemaRepository;
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
public class CinemaServiceTest {
    @Mock
    private CinemaRepository repository;

    @InjectMocks
    private CinemaServiceImpl service;

    private List<Cinema> cinemaList;

    private Cinema cinemaToCompareWith;

    @Before
    public void setUp() throws Exception {
        cinemaList = Arrays.asList(
                new Cinema("Cinema", "Address", 1),
                new Cinema("Cinema", "Address", 1),
                new Cinema("Cinema", "Address", 1)
        );

        cinemaToCompareWith = new Cinema("Cinema", "Address", 1);
        Mockito.when(repository.findAll()).thenReturn(cinemaList);
        Mockito.when(repository.save(cinemaToCompareWith)).thenReturn(cinemaToCompareWith);

    }

    @Test
    public void insertCinema() throws Exception {
        Cinema cinema = service.insertCinema(cinemaToCompareWith);

        assertEquals(cinema, cinemaToCompareWith);
    }

    @Test
    public void getCinema() throws Exception {
        int idToFind = 1;

        Cinema expectedCinema = new Cinema("some", "some", 1);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedCinema));

        Cinema cinema = service.getCinema(idToFind);
        Assert.assertEquals(expectedCinema, cinema);
    }

    @Test
    public void updateCinema() throws Exception {
        Cinema cinema = service.updateCinema(cinemaToCompareWith);

        assertEquals(cinemaToCompareWith, cinema);
    }

    @Test
    public void getAll() throws Exception {
        List<Cinema> listToCompareWith = service.getAll();

        assertEquals(cinemaList, listToCompareWith);
    }

    @Test
    public void findAllByScreenSizeGreaterThanEqual() throws Exception {
        List<Cinema> cinemas = Arrays.asList(
                new Cinema("Cinema 1", "Add 1", 100),
                new Cinema("Cinema 2", "Add 1", 120),
                new Cinema("Cinema 3", "Add 1", 130)
        );

        int size = 100;

        Mockito.when(repository.findAllByScreenSizeGreaterThanEqual(size)).thenReturn(cinemas);

        List<Cinema> actualCinemas = service.findAllByScreenSizeGreaterThanEqual(size);

        assertEquals(cinemas, actualCinemas);
    }

}