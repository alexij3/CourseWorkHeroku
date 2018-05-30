package com.buzilov.lab6crud.service.theatre;

import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.repository.theatre.TheatreRepository;
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
public class TheatreServiceTest {
    @Mock
    private TheatreRepository repository;

    @InjectMocks
    private TheatreServiceImpl service;

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

        Mockito.when(repository.findAll()).thenReturn(theatreList);
        Mockito.when(repository.save(theatreToCompareWith)).thenReturn(theatreToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        Theatre theatre = service.insert(theatreToCompareWith);

        assertEquals(theatre, theatreToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        Theatre expectedTheatre = new Theatre("Some", "some", 10);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedTheatre));

        Theatre theatre = service.get(idToFind);
        Assert.assertEquals(expectedTheatre, theatre);
    }

    @Test
    public void update() throws Exception {
        Theatre theatre = service.update(theatreToCompareWith);

        assertEquals(theatre, theatreToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<Theatre> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, theatreList);
    }

}