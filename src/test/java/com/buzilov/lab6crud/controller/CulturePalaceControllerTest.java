package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.CulturePalace;
import com.buzilov.lab6crud.service.culturepalace.CulturePalaceServiceImpl;
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
public class CulturePalaceControllerTest {
    @Mock
    private CulturePalaceServiceImpl service;

    @InjectMocks
    private CulturePalaceController controller;

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

        Mockito.when(service.getAll()).thenReturn(culturePalaceList);
        Mockito.when(service.insert(culturePalaceToCompareWith)).thenReturn(culturePalaceToCompareWith);
        Mockito.when(service.update(culturePalaceToCompareWith)).thenReturn(culturePalaceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        CulturePalace culturePalace = controller.create(culturePalaceToCompareWith);

        assertEquals(culturePalace, culturePalaceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        CulturePalace expectedCulturePalace = new CulturePalace("Some", "some", 10);
        Mockito.when(service.get(idToFind)).thenReturn(expectedCulturePalace);

        CulturePalace culturePalace = controller.get(idToFind);
        Assert.assertEquals(expectedCulturePalace, culturePalace);
    }

    @Test
    public void update() throws Exception {
        CulturePalace culturePalace = controller.update(culturePalaceToCompareWith.getId(), culturePalaceToCompareWith);

        assertEquals(culturePalace, culturePalaceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<CulturePalace> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, culturePalaceList);
    }

    @Test
    public void findAllByCapacityGreaterThanEqual() throws Exception {
        List<CulturePalace> culturePalaces = Arrays.asList(
                new CulturePalace("CulturePalace 1", "Add 1", 60),
                new CulturePalace("CulturePalace 2", "Add 2", 70),
                new CulturePalace("CulturePalace 3", "Add 3", 80)
        );

        int capacity = 50;

        Mockito.when(service.findAllByCapacityGreaterThanEqual(capacity)).thenReturn(culturePalaces);

        List<CulturePalace> actualCulturePalaces = controller.findAllByCapacityGreaterThanEqual(capacity);

        assertEquals(culturePalaces, actualCulturePalaces);

    }
}