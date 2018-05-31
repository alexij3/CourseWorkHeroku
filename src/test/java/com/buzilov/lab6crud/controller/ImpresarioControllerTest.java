package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.service.impresario.ImpresarioServiceImpl;
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
public class ImpresarioControllerTest {
    @Mock
    private ImpresarioServiceImpl service;

    @InjectMocks
    private ImpresarioController controller;

    private List<Impresario> impresarioList;

    private Impresario impresarioToCompareWith;

    @Before
    public void setUp() throws Exception {
        impresarioList = Arrays.asList(
                new Impresario("Impresario 1") ,
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3"),
                new Impresario("Impresario 4"),
                new Impresario("Impresario 5")
        );

        impresarioToCompareWith = new Impresario("Impresario Comparison");

        Mockito.when(service.getAll()).thenReturn(impresarioList);
        Mockito.when(service.insert(impresarioToCompareWith)).thenReturn(impresarioToCompareWith);
        Mockito.when(service.update(impresarioToCompareWith)).thenReturn(impresarioToCompareWith);

    }

    @Test
    public void getAll() throws Exception {
        List<Impresario> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, impresarioList);
    }

    @Test
    public void insertImpresario() throws Exception {
        Impresario impresario = controller.create(impresarioToCompareWith);

        assertEquals(impresario, impresarioToCompareWith);
    }

    @Test
    public void getImpresario() throws Exception {
        int idToFind = 1;

        Impresario expectedImpresario = new Impresario("Some");
        Mockito.when(service.get(idToFind)).thenReturn(expectedImpresario);

        Impresario impresario = controller.get(idToFind);
        Assert.assertEquals(expectedImpresario, impresario);
    }

    @Test
    public void updateImpresario() throws Exception {
        Impresario impresario = controller.update(impresarioToCompareWith.getId(), impresarioToCompareWith);

        assertEquals(impresario, impresarioToCompareWith);
    }

    @Test
    public void findAllByGenreSetContaining() throws Exception {
        List<Impresario> impresariosWithGenres = Arrays.asList(
                new Impresario("Impresario 1"),
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3")
        );

        Genre genre = Genre.Комедія;

        impresariosWithGenres.get(0).getGenreSet().add(genre);
        impresariosWithGenres.get(1).getGenreSet().add(genre);
        impresariosWithGenres.get(2).getGenreSet().add(genre);

        Mockito.when(service.findAllByGenreSetContaining(genre)).thenReturn(impresariosWithGenres);

        List<Impresario> controllerTestImpresarios = controller.findAllByGenreSetContaining(genre);

        assertEquals(controllerTestImpresarios, impresariosWithGenres);
    }

    @Test
    public void findAllByGenreSetIsNull() throws Exception {
        Mockito.when(service.findAllByGenreSetIsNull()).thenReturn(impresarioList);

        List<Impresario> impresariosToCheck = controller.findAllByGenreSetIsNull();

        assertEquals(impresarioList, impresariosToCheck);
    }

    @Test
    public void findAllByAgeLessThan() throws Exception {
        int age = 23;

        List<Impresario> impresarios = Arrays.asList(
                new Impresario("Impresario 1"),
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3")
        );

        for (Impresario a : impresarios)
            a.setAge(22);

        Mockito.when(service.findAllByAgeLessThan(age)).thenReturn(impresarios);

        List<Impresario> actualImpresarios = controller.findAllByAgeLessThan(age);

        assertEquals(impresarios, actualImpresarios);
    }

    @Test
    public void findAllByAgeGreaterThanEqual() throws Exception {
        int age = 23;

        List<Impresario> impresarios = Arrays.asList(
                new Impresario("Impresario 1"),
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3")
        );

        for (Impresario a : impresarios)
            a.setAge(24);

        Mockito.when(service.findAllByAgeGreaterThanEqual(age)).thenReturn(impresarios);

        List<Impresario> actualImpresarios = controller.findAllByAgeGreaterThanEqual(age);

        assertEquals(impresarios, actualImpresarios);
    }

    @Test
    public void findAllByExperienceLessThan() throws Exception {
        int experience = 3;

        List<Impresario> impresarios = Arrays.asList(
                new Impresario("Impresario 1"),
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3")
        );

        for (Impresario a : impresarios)
            a.setExperience(2);

        Mockito.when(service.findAllByExperienceLessThan(experience)).thenReturn(impresarios);

        List<Impresario> actualImpresarios = controller.findAllByExperienceLessThan(experience);

        assertEquals(impresarios, actualImpresarios);
    }

    @Test
    public void findAllByExperienceGreaterThanEqual() throws Exception {
        int experience = 3;

        List<Impresario> impresarios = Arrays.asList(
                new Impresario("Impresario 1"),
                new Impresario("Impresario 2"),
                new Impresario("Impresario 3")
        );

        for (Impresario a : impresarios)
            a.setExperience(4);

        Mockito.when(service.findAllByExperienceGreaterThanEqual(experience)).thenReturn(impresarios);

        List<Impresario> actualImpresarios = controller.findAllByExperienceGreaterThanEqual(experience);

        assertEquals(impresarios, actualImpresarios);
    }
}
