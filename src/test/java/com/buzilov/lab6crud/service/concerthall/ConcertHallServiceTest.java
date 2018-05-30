package com.buzilov.lab6crud.service.concerthall;

import com.buzilov.lab6crud.model.ConcertHall;
import com.buzilov.lab6crud.repository.concerthall.ConcertHallRepository;
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
public class ConcertHallServiceTest {
    @Mock
    private ConcertHallRepository repository;

    @InjectMocks
    private ConcertHallServiceImpl service;

    private List<ConcertHall> concertHallList;

    private ConcertHall concertHallToCompareWith;

    @Before
    public void setUp() throws Exception {
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