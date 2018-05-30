package com.buzilov.lab6crud.service.artist;

import com.buzilov.lab6crud.model.Artist;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

}