package com.buzilov.lab6crud.service.cinema;

import com.buzilov.lab6crud.model.Cinema;
import com.buzilov.lab6crud.repository.cinema.CinemaRepository;
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
public class CinemaServiceTest {
    @Mock
    private CinemaRepository repository;

    @InjectMocks
    private CinemaServiceImpl service;

    private List<Cinema> cinemaList;

    private Cinema cinemaToCompareWith;

    @Test
    public void insertCinema1() throws Exception {
    }

    @Test
    public void getCinema1() throws Exception {
    }

    @Test
    public void updateCinema1() throws Exception {
    }

    @Test
    public void getAll1() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insertCinema() throws Exception {
    }

    @Test
    public void getCinema() throws Exception {
    }

    @Test
    public void updateCinema() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}