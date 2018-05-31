package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.repository.organizer.OrganizerRepository;
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
public class OrganizerServiceTest {
    @Mock
    private OrganizerRepository repository;

    @InjectMocks
    private OrganizerServiceImpl service;

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

        Mockito.when(repository.findAll()).thenReturn(organizerList);
        Mockito.when(repository.save(organizerToCompareWith)).thenReturn(organizerToCompareWith);

    }

    @Test
    public void getAll() throws Exception {
        List<Organizer> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, organizerList);
    }

    @Test
    public void insertOrganizer() throws Exception {
        Organizer organizer = service.insert(organizerToCompareWith);

        assertEquals(organizer, organizerToCompareWith);
    }

    @Test
    public void getOrganizer() throws Exception {
        int idToFind = 1;

        Organizer expectedOrganizer = new Organizer("Some");
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedOrganizer));

        Organizer organizer = service.get(idToFind);
        Assert.assertEquals(expectedOrganizer, organizer);
    }

    @Test
    public void updateOrganizer() throws Exception {
        Organizer organizer = service.update(organizerToCompareWith);

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

        Mockito.when(repository.findAllAndConcertCount(firstDate, secondDate)).thenReturn(organizers);

        List<Organizer> actualOrganizers = service.findAllAndConcertCount(firstDate, secondDate);

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

        Mockito.when(repository.findAllByAgeLessThan(age)).thenReturn(organizers);

        List<Organizer> actualOrganizers = service.findAllByAgeLessThan(age);

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

        Mockito.when(repository.findAllByAgeGreaterThanEqual(age)).thenReturn(organizers);

        List<Organizer> actualOrganizers = service.findAllByAgeGreaterThanEqual(age);

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

        Mockito.when(repository.findAllByExperienceLessThan(experience)).thenReturn(organizers);

        List<Organizer> actualOrganizers = service.findAllByExperienceLessThan(experience);

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

        Mockito.when(repository.findAllByExperienceGreaterThanEqual(experience)).thenReturn(organizers);

        List<Organizer> actualOrganizers = service.findAllByExperienceGreaterThanEqual(experience);

        assertEquals(organizers, actualOrganizers);
    }

}