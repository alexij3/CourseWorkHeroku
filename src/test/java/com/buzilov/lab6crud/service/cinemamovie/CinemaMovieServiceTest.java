package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.model.Cinema;
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

import java.time.LocalDate;
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

        Mockito.when(repository.findAllByCinemaId(id)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = service.findAllByCinemaId(id);

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

        Mockito.when(repository.findAllByDateBetween(firstDate, secondDate)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = service.findAllByDateBetween(firstDate, secondDate);

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

        Mockito.when(repository.findAllByGenre(genre)).thenReturn(cinemaMovies);

        List<CinemaMovie> actualCinemaMovies = service.findAllByGenre(genre);

        assertEquals(cinemaMovies, actualCinemaMovies);
    }

}