package com.buzilov.lab6crud.service.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;
import com.buzilov.lab6crud.repository.contestinpalace.ContestInPalaceRepository;
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
public class ContestInPalaceServiceTest {
    @Mock
    private ContestInPalaceRepository repository;

    @InjectMocks
    private ContestInPalaceServiceImpl service;

    private List<ContestInPalace> contestInPalaceList;

    private ContestInPalace contestInPalaceToCompareWith;

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