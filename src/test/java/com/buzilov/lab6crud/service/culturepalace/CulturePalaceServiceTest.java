package com.buzilov.lab6crud.service.culturepalace;

import com.buzilov.lab6crud.model.CulturePalace;
import com.buzilov.lab6crud.repository.culturepalace.CulturePalaceRepository;
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
public class CulturePalaceServiceTest {
    @Mock
    private CulturePalaceRepository repository;

    @InjectMocks
    private CulturePalaceServiceImpl service;

    private List<CulturePalace> culturePalaceList;

    private CulturePalace culturePalaceToCompareWith;

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