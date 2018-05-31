package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Cinema;
import com.buzilov.lab6crud.model.CinemaMovie;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.service.cinemamovie.CinemaMovieServiceImpl;
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
public class CinemaMoviesControllerTest {
    @Mock
    private CinemaMovieServiceImpl service;

    @InjectMocks
    private CinemaMoviesController controller;

    private List<CinemaMovie> cinemaMovieList;

    private CinemaMovie cinemaMovieToCompareWith;

    @Before
    public void setUp() throws Exception {
        cinemaMovieList = Arrays.asList(
                new CinemaMovie("some", Genre.Комедія, null),
                new CinemaMovie("some", Genre.Комедія, null),
                new CinemaMovie("some", Genre.Комедія, null)
        );

        Cinema cinema = new Cinema("Cinema", "Address", 50);
        int cinemaId = 2;
        cinema.setId(cinemaId);

        cinemaMovieToCompareWith = new CinemaMovie("some", Genre.Комедія, null);
        cinemaMovieToCompareWith.setId(1);
        cinemaMovieToCompareWith.setCinema(cinema);
        cinemaMovieToCompareWith.setCinemaId(cinemaId);


        Mockito.when(service.getAll()).thenReturn(cinemaMovieList);
        Mockito.when(service.insert(cinemaMovieToCompareWith)).thenReturn(cinemaMovieToCompareWith);
        Mockito.when(service.update(cinemaMovieToCompareWith)).thenReturn(cinemaMovieToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        CinemaMovie cinemaMovie = controller.create(cinemaMovieToCompareWith);

        assertEquals(cinemaMovie, cinemaMovieToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        CinemaMovie expectedCinemaMovie = new CinemaMovie("Some", null, null);
        Mockito.when(service.get(idToFind)).thenReturn(expectedCinemaMovie);

        CinemaMovie cinemaMovie = controller.get(idToFind);
        Assert.assertEquals(expectedCinemaMovie, cinemaMovie);
    }

    @Test
    public void update() throws Exception {
        CinemaMovie cinemaMovie = controller.update(cinemaMovieToCompareWith.getId(), cinemaMovieToCompareWith);

        assertEquals(cinemaMovie, cinemaMovieToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<CinemaMovie> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, cinemaMovieList);
    }

    @Test
    public void findAllByCinemaId() throws Exception {
        Cinema cinema = new Cinema("Cinema", "address", 50);

        int id = 2;

        cinema.setId(id);
        LocalDate date = LocalDate.of(2018, 4, 5);

        List<CinemaMovie> cinemaMovies = Arrays.asList(
                new CinemaMovie("Movie 1", Genre.Боєвик, cinema, id, date),
                new CinemaMovie("Movie 2", Genre.Комедія, cinema, id, date),
                new CinemaMovie("Movie 3", Genre.Детектив, cinema, id, date)
        );

        Mockito.when(service.findAllByCinemaId(id)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = controller.findAllByCinemaId(id);

        assertEquals(cinemaMovies, actualCinemaMovies);
    }

    @Test
    public void findAllByDateBetween() throws Exception {
        LocalDate firstDate = LocalDate.of(2018, 4, 10);
        LocalDate secondDate = LocalDate.of(2018, 4, 16);

        Cinema cinema = new Cinema("Cinema", "address", 50);

        int id = 2;

        cinema.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        List<CinemaMovie> cinemaMovies = Arrays.asList(
                new CinemaMovie("Movie 1", Genre.Боєвик, cinema, id, date),
                new CinemaMovie("Movie 2", Genre.Комедія, cinema, id, date),
                new CinemaMovie("Movie 3", Genre.Детектив, cinema, id, date)
        );

        Mockito.when(service.findAllByDateBetween(firstDate, secondDate)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = controller.findAllByDateBetween(firstDate.toString(), secondDate.toString());

        assertEquals(cinemaMovies, actualCinemaMovies);
    }

    @Test
    public void findAllByGenre() throws Exception {
        Cinema cinema = new Cinema("Cinema", "address", 50);

        int id = 2;

        cinema.setId(id);

        LocalDate date = LocalDate.of(2018, 4, 13);

        Genre genre = Genre.Детектив;

        List<CinemaMovie> cinemaMovies = Arrays.asList(
                new CinemaMovie("Movie 1", genre, cinema, id, date),
                new CinemaMovie("Movie 2", genre, cinema, id, date),
                new CinemaMovie("Movie 3", genre, cinema, id, date)
        );

        Mockito.when(service.findAllByGenre(genre)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = controller.findAllByGenre(genre);

        assertEquals(cinemaMovies, actualCinemaMovies);
    }
}