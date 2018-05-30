package com.buzilov.lab6crud.service.theatreperformance;

import com.buzilov.lab6crud.model.TheatrePerformance;
import com.buzilov.lab6crud.repository.theatreperformance.TheatrePerformanceRepository;
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
public class TheatrePerformanceServiceTest {
    @Mock
    private TheatrePerformanceRepository repository;

    @InjectMocks
    private TheatrePerformanceServiceImpl service;

    private List<TheatrePerformance> theatrePerformanceList;

    private TheatrePerformance theatrePerformanceToCompareWith;


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