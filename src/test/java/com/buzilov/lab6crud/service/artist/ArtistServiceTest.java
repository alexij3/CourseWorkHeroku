package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.model.*;
import com.buzilov.lab6crud.repository.artist.ArtistRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ArtistServiceTest {
    @Mock
    private ArtistRepository repository;

    @InjectMocks
    private ArtistServiceImpl service;

    private List<Artist> artistList;

    private Artist artistToCompareWith;

    @Before
    public void setUp() throws Exception {
        artistList = Arrays.asList(
            new Artist("Artist 1") ,
            new Artist("Artist 2"),
            new Artist("Artist 3")
        );

        artistList.get(0).setId(1);
        artistList.get(1).setId(2);
        artistList.get(2).setId(3);

        artistToCompareWith = new Artist("Artist Comparison");

        Mockito.when(repository.findAll()).thenReturn(artistList);
        Mockito.when(repository.save(artistToCompareWith)).thenReturn(artistToCompareWith);

    }

    @Test
    public void getAll() throws Exception {
        List<Artist> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, artistList);
    }

    @Test
    public void insertArtist() throws Exception {
        Artist artist = service.insertArtist(artistToCompareWith);

        assertEquals(artist, artistToCompareWith);
    }

    @Test
    public void getArtist() throws Exception {
        int idToFind = 1;

        Artist expectedArtist = new Artist("Some");
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedArtist));

        Artist artist = service.getArtist(idToFind);
        Assert.assertEquals(expectedArtist, artist);
    }

    @Test
    public void updateArtist() throws Exception {
        Artist artist = service.updateArtist(artistToCompareWith);

        assertEquals(artist, artistToCompareWith);
    }

    @Test
    public void findAllByGenreSetContaining() throws Exception {
        List<Artist> artistsWithGenres = Arrays.asList(
                new Artist("Artist 1"),
                new Artist("Artist 2"),
                new Artist("Artist 3")
        );

        Genre genre = Genre.Комедія;

        artistsWithGenres.get(0).getGenreSet().add(genre);
        artistsWithGenres.get(1).getGenreSet().add(genre);
        artistsWithGenres.get(2).getGenreSet().add(genre);

        Mockito.when(repository.findAllByGenreSetContaining(genre)).thenReturn(artistsWithGenres);

        List<Artist> serviceTestArtists = service.findAllByGenreSetContaining(genre);

        assertEquals(serviceTestArtists, artistsWithGenres);
    }

    @Test
    public void findArtistByImpresariosContaining() throws Exception {
        Impresario impresario = new Impresario("Some impresario");
        List<Artist> artists = Arrays.asList(
            new Artist("Artist 1"),
            new Artist("Artist 2")
        );

        for (Artist a : artists)
            a.getImpresarios().add(impresario);

        Mockito.when(repository.findArtistByImpresariosContaining(impresario)).thenReturn(artists);

        List<Artist> artistsToCheck = service.findArtistByImpresariosContaining(impresario);

        assertEquals(artists, artistsToCheck);
    }

    @Test
    public void findAllByContestDateNotBetween() throws Exception {
        List<ContestInPalace> contestInPalaceList = Arrays.asList(
                new ContestInPalace(new CulturePalace(), 1, "Name 1", new Organizer(), 1, LocalDate.of(2018, 2, 5)),
                new ContestInPalace(new CulturePalace(), 2, "Name 2",  new Organizer(), 2, LocalDate.of(2018, 2, 7)),
                new ContestInPalace(new CulturePalace(), 3, "Name 3",  new Organizer(), 3, LocalDate.of(2018, 2, 9))
        );

        Artist artist = new Artist("Artist 1");
        Artist anotherArtist = new Artist("Artist 2");

        Set<ContestResults> contestResults = new HashSet<>();
        Set<ContestResults> otherResults = new HashSet<>();

        contestResults.add(new ContestResults(artist, contestInPalaceList.get(0), 1, 'y'));
        contestResults.add(new ContestResults(artist, contestInPalaceList.get(1), 2, 'y'));
        contestResults.add(new ContestResults(artist, contestInPalaceList.get(2), 3, 'y'));
        otherResults.add(new ContestResults(anotherArtist, contestInPalaceList.get(1), 4, 'n'));
        otherResults.add(new ContestResults(anotherArtist, contestInPalaceList.get(2), 5, 'n'));

        artist.setContestResults(contestResults);
        anotherArtist.setContestResults(otherResults);

        List<Artist> artistList = new ArrayList<>();

        artistList.add(artist);
        artistList.add(anotherArtist);

        LocalDate firstDate = LocalDate.of(2018, 2, 2);
        LocalDate secondDate = LocalDate.of(2018, 2, 4);

        Mockito.when(repository.findAllByContestDateNotBetween(firstDate, secondDate)).thenReturn(artistList);

        List<Artist> artistsToCheck = service.findAllByContestDateNotBetween(firstDate, secondDate);

        assertEquals(artistList, artistsToCheck);
    }

    @Test
    public void findAllByGenreSetIsNull() throws Exception {
        Mockito.when(repository.findAllByGenreSetIsNull()).thenReturn(artistList);

        List<Artist> artistsToCheck = service.findAllByGenreSetIsNull();

        assertEquals(artistList, artistsToCheck);
    }

    @Test
    public void findAllByAgeLessThan() throws Exception {
        int age = 23;

        List<Artist> artists = Arrays.asList(
                new Artist("Artist 1"),
                new Artist("Artist 2"),
                new Artist("Artist 3")
        );

        for (Artist a : artists)
            a.setAge(22);

        Mockito.when(repository.findAllByAgeLessThan(age)).thenReturn(artists);

        List<Artist> actualArtists = service.findAllByAgeLessThan(age);

        assertEquals(artists, actualArtists);
    }

    @Test
    public void findAllByAgeGreaterThanEqual() throws Exception {
        int age = 23;

        List<Artist> artists = Arrays.asList(
                new Artist("Artist 1"),
                new Artist("Artist 2"),
                new Artist("Artist 3")
        );

        for (Artist a : artists)
            a.setAge(24);

        Mockito.when(repository.findAllByAgeGreaterThanEqual(age)).thenReturn(artists);

        List<Artist> actualArtists = service.findAllByAgeGreaterThanEqual(age);

        assertEquals(artists, actualArtists);
    }

    @Test
    public void findAllByExperienceLessThan() throws Exception {
        int experience = 3;

        List<Artist> artists = Arrays.asList(
                new Artist("Artist 1"),
                new Artist("Artist 2"),
                new Artist("Artist 3")
        );

        for (Artist a : artists)
            a.setExperience(2);

        Mockito.when(repository.findAllByExperienceLessThan(experience)).thenReturn(artists);

        List<Artist> actualArtists = service.findAllByExperienceLessThan(experience);

        assertEquals(artists, actualArtists);
    }

    @Test
    public void findAllByExperienceGreaterThanEqual() throws Exception {
        int experience = 3;

        List<Artist> artists = Arrays.asList(
                new Artist("Artist 1"),
                new Artist("Artist 2"),
                new Artist("Artist 3")
        );

        for (Artist a : artists)
            a.setExperience(4);

        Mockito.when(repository.findAllByExperienceGreaterThanEqual(experience)).thenReturn(artists);

        List<Artist> actualArtists = service.findAllByExperienceGreaterThanEqual(experience);

        assertEquals(artists, actualArtists);
    }
}