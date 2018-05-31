package com.buzilov.lab6crud.controller;

import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.service.organizer.OrganizerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OrganizerControllerTest {
    @Mock
    private OrganizerServiceImpl service;

    @InjectMocks
    private OrganizerController controller;

    private List<Organizer> organizerList;

    private Organizer organizerToCompareWith;

    @Before
    public void setUp() throws Exception {
        organizerList = Arrays.asList(
                new Organizer("Organizer 1") ,
                new Organizer("Organizer 2"),
                new Organizer("Organizer 3"),
                new Organizer("Organizer 4"),
                new Organizer("Organizer 5")
        );

        organizerToCompareWith = new Organizer("Organizer Comparison");
        organizerToCompareWith.setId(1);

        Mockito.when(service.getAll()).thenReturn(organizerList);
        Mockito.when(service.insert(organizerToCompareWith)).thenReturn(organizerToCompareWith);
        Mockito.when(service.update(organizerToCompareWith)).thenReturn(organizerToCompareWith);

    }

    @Test
    public void getAll() throws Exception {
        List<Organizer> listToCompareWith = controller.getAll();

        assertEquals(listToCompareWith, organizerList);
    }

    @Test
    public void insertOrganizer() throws Exception {
        Organizer organizer = controller.create(organizerToCompareWith);

        assertEquals(organizer, organizerToCompareWith);
    }

    @Test
    public void getOrganizer() throws Exception {
        int idToFind = 1;

        Organizer expectedOrganizer = new Organizer("Some");
        Mockito.when(service.get(idToFind)).thenReturn(expectedOrganizer);

        Organizer organizer = controller.get(idToFind);
        Assert.assertEquals(expectedOrganizer, organizer);
    }

    @Test
    public void updateOrganizer() throws Exception {
        Organizer organizer = controller.update(organizerToCompareWith.getId(), organizerToCompareWith);

        assertEquals(organizer, organizerToCompareWith);
    }

    @Test
    public void findAllAndConcertCount() throws Exception {
        List<Organizer> organizers = Arrays.asList(
                new Organizer("Org 1", 5),
                new Organizer("Org 1", 6),
                new Organizer("Org 1", 2),
                new Organizer("Org 1", 4)
        );

        LocalDate firstDate = LocalDate.of(2018, 2, 2);
        LocalDate secondDate = LocalDate.of(2018, 2, 6);

        Mockito.when(service.findAllAndConcertCount(firstDate, secondDate)).thenReturn(organizers);

        List<Organizer> actualOrganizers = controller.findAllAndConcertCount(firstDate.toString(), secondDate.toString());

        assertEquals(organizers, actualOrganizers);
    }

    @Test
    public void findAllByAgeLessThan() throws Exception {
        int age = 23;

        List<Organizer> organizers = Arrays.asList(
                new Organizer("Organizer 1"),
                new Organizer("Organizer 2"),
                new Organizer("Organizer 3")
        );

        for (Organizer a : organizers)
            a.setAge(22);

        Mockito.when(service.findAllByAgeLessThan(age)).thenReturn(organizers);

        List<Organizer> actualOrganizers = controller.findAllByAgeLessThan(age);

        assertEquals(organizers, actualOrganizers);
    }

    @Test
    public void findAllByAgeGreaterThanEqual() throws Exception {
        int age = 23;

        List<Organizer> organizers = Arrays.asList(
                new Organizer("Organizer 1"),
                new Organizer("Organizer 2"),
                new Organizer("Organizer 3")
        );

        for (Organizer a : organizers)
            a.setAge(24);

        Mockito.when(service.findAllByAgeGreaterThanEqual(age)).thenReturn(organizers);

        List<Organizer> actualOrganizers = controller.findAllByAgeGreaterThanEqual(age);

        assertEquals(organizers, actualOrganizers);
    }

    @Test
    public void findAllByExperienceLessThan() throws Exception {
        int experience = 3;

        List<Organizer> organizers = Arrays.asList(
                new Organizer("Organizer 1"),
                new Organizer("Organizer 2"),
                new Organizer("Organizer 3")
        );

        for (Organizer a : organizers)
            a.setExperience(2);

        Mockito.when(service.findAllByExperienceLessThan(experience)).thenReturn(organizers);

        List<Organizer> actualOrganizers = controller.findAllByExperienceLessThan(experience);

        assertEquals(organizers, actualOrganizers);
    }

    @Test
    public void findAllByExperienceGreaterThanEqual() throws Exception {
        int experience = 3;

        List<Organizer> organizers = Arrays.asList(
                new Organizer("Organizer 1"),
                new Organizer("Organizer 2"),
                new Organizer("Organizer 3")
        );

        for (Organizer a : organizers)
            a.setExperience(4);

        Mockito.when(service.findAllByExperienceGreaterThanEqual(experience)).thenReturn(organizers);

        List<Organizer> actualOrganizers = controller.findAllByExperienceGreaterThanEqual(experience);

        assertEquals(organizers, actualOrganizers);
    }
}