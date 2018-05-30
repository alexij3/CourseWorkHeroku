package com.buzilov.lab6crud.service.theatre;

import com.buzilov.lab6crud.model.Theatre;
import com.buzilov.lab6crud.repository.theatre.TheatreRepository;
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
public class TheatreServiceTest {
    @Mock
    private TheatreRepository repository;

    @InjectMocks
    private TheatreServiceImpl service;

    private List<Theatre> theatreList;

    private Theatre theatreToCompareWith;

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