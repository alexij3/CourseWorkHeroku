package com.buzilov.lab6crud.service.cinemamovie;

import com.buzilov.lab6crud.model.CinemaMovie;
import com.buzilov.lab6crud.repository.cinemamovie.CinemaMovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

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
    }

    @Test
    public void insert1() throws Exception {
    }

    @Test
    public void get1() throws Exception {
    }

    @Test
    public void update1() throws Exception {
    }

    @Test
    public void getAll1() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}