package com.buzilov.lab6crud.service.theatreperformance;

import com.buzilov.lab6crud.model.TheatrePerformance;
import com.buzilov.lab6crud.repository.theatreperformance.TheatrePerformanceRepository;
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
public class TheatrePerformanceServiceTest {
    @Mock
    private TheatrePerformanceRepository repository;

    @InjectMocks
    private TheatrePerformanceServiceImpl service;

    private List<TheatrePerformance> theatrePerformanceList;

    private TheatrePerformance theatrePerformanceToCompareWith;


    @Before
    public void setUp() throws Exception {
        theatrePerformanceList = Arrays.asList(
                new TheatrePerformance(null, 0, "Name 1", null, 0, null),
                new TheatrePerformance(null, 0, "Name 2", null, 0, null),
                new TheatrePerformance(null, 0, "Name 3", null, 0, null)
        );

        theatrePerformanceToCompareWith =  new TheatrePerformance(null, 0, "Name 4", null, 0, null);

        Mockito.when(repository.findAll()).thenReturn(theatrePerformanceList);
        Mockito.when(repository.save(theatrePerformanceToCompareWith)).thenReturn(theatrePerformanceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        TheatrePerformance theatrePerformance = service.insert(theatrePerformanceToCompareWith);

        assertEquals(theatrePerformance, theatrePerformanceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        TheatrePerformance expectedTheatrePerformance = new TheatrePerformance(null, 0, "Name 5", null, 0, null);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedTheatrePerformance));

        TheatrePerformance theatrePerformance = service.get(idToFind);
        Assert.assertEquals(expectedTheatrePerformance, theatrePerformance);
    }

    @Test
    public void update() throws Exception {
        TheatrePerformance theatrePerformance = service.update(theatrePerformanceToCompareWith);

        assertEquals(theatrePerformance, theatrePerformanceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<TheatrePerformance> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, theatrePerformanceList);
    }

    @Test
    public void findAllByDateBetween() throws Exception {
    }

    @Test
    public void findAllByDateBetweenAndOrganizerId() throws Exception {
    }

    @Test
    public void findAllByTheatreId() throws Exception {
    }

}