package com.buzilov.lab6crud.service.culturepalace;

import com.buzilov.lab6crud.model.CulturePalace;
import com.buzilov.lab6crud.repository.culturepalace.CulturePalaceRepository;
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
public class CulturePalaceServiceTest {
    @Mock
    private CulturePalaceRepository repository;

    @InjectMocks
    private CulturePalaceServiceImpl service;

    private List<CulturePalace> culturePalaceList;

    private CulturePalace culturePalaceToCompareWith;

    @Before
    public void setUp() throws Exception {
        culturePalaceList = Arrays.asList(
                new CulturePalace("Name 1", "Add 1", 10),
                new CulturePalace("Name 2", "Add 2", 10),
                new CulturePalace("Name 3", "Add 3", 10),
                new CulturePalace("Name 4", "Add 4", 10)
        );

        culturePalaceToCompareWith = new CulturePalace("Name 5", "Add 5", 10);

        Mockito.when(repository.findAll()).thenReturn(culturePalaceList);
        Mockito.when(repository.save(culturePalaceToCompareWith)).thenReturn(culturePalaceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        CulturePalace culturePalace = service.insert(culturePalaceToCompareWith);

        assertEquals(culturePalace, culturePalaceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        CulturePalace expectedCulturePalace = new CulturePalace("Some", "some", 10);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedCulturePalace));

        CulturePalace culturePalace = service.get(idToFind);
        Assert.assertEquals(expectedCulturePalace, culturePalace);
    }

    @Test
    public void update() throws Exception {
        CulturePalace culturePalace = service.update(culturePalaceToCompareWith);

        assertEquals(culturePalace, culturePalaceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<CulturePalace> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, culturePalaceList);
    }

}