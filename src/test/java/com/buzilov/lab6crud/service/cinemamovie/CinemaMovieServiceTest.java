package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.repository.cinemamovie.CinemaMovieRepository;
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
public class CinemaMovieServiceTest {
    @Mock
    private CinemaMovieRepository repository;

    @InjectMocks
    private CinemaMovieServiceImpl service;

    private List<CinemaMovie> cinemaMovieList;

    private CinemaMovie cinemaMovieToCompareWith;

    @Before
    public void setUp() throws Exception {
        cinemaMovieList = Arrays.asList(
                new CinemaMovie("some", Genre.Комедія, null),
                new CinemaMovie("some", Genre.Комедія, null),
                new CinemaMovie("some", Genre.Комедія, null)
        );

        cinemaMovieToCompareWith = new CinemaMovie("some", Genre.Комедія, null);
        Mockito.when(repository.findAll()).thenReturn(cinemaMovieList);
        Mockito.when(repository.save(cinemaMovieToCompareWith)).thenReturn(cinemaMovieToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        CinemaMovie cinemaMovie = service.insert(cinemaMovieToCompareWith);

        assertEquals(cinemaMovie, cinemaMovieToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        CinemaMovie expectedCinemaMovie = new CinemaMovie("Some", null, null);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedCinemaMovie));

        CinemaMovie cinemaMovie = service.get(idToFind);
        Assert.assertEquals(expectedCinemaMovie, cinemaMovie);
    }

    @Test
    public void update() throws Exception {
        CinemaMovie cinemaMovie = service.update(cinemaMovieToCompareWith);

        assertEquals(cinemaMovie, cinemaMovieToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<CinemaMovie> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, cinemaMovieList);
    }

}