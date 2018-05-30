package com.buzilov.lab6crud.service.contestinpalace;

import com.buzilov.lab6crud.model.ContestInPalace;
import com.buzilov.lab6crud.repository.contestinpalace.ContestInPalaceRepository;
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
public class ContestInPalaceServiceTest {
    @Mock
    private ContestInPalaceRepository repository;

    @InjectMocks
    private ContestInPalaceServiceImpl service;

    private List<ContestInPalace> contestInPalaceList;

    private ContestInPalace contestInPalaceToCompareWith;

    @Before
    public void setUp() throws Exception {
        contestInPalaceList = Arrays.asList(
                new ContestInPalace(null, 0, "Name 1", null, 0, null),
                new ContestInPalace(null, 0, "Name 2", null, 0, null),
                new ContestInPalace(null, 0, "Name 3", null, 0, null)
        );

        contestInPalaceToCompareWith =  new ContestInPalace(null, 0, "Name 4", null, 0, null);

        Mockito.when(repository.findAll()).thenReturn(contestInPalaceList);
        Mockito.when(repository.save(contestInPalaceToCompareWith)).thenReturn(contestInPalaceToCompareWith);
    }

    @Test
    public void insert() throws Exception {
        ContestInPalace contestInPalace = service.insert(contestInPalaceToCompareWith);

        assertEquals(contestInPalace, contestInPalaceToCompareWith);
    }

    @Test
    public void get() throws Exception {
        int idToFind = 1;

        ContestInPalace expectedContestInPalace = new ContestInPalace(null, 0, "Name 5", null, 0, null);
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedContestInPalace));

        ContestInPalace contestInPalace = service.get(idToFind);
        Assert.assertEquals(expectedContestInPalace, contestInPalace);
    }

    @Test
    public void update() throws Exception {
        ContestInPalace contestInPalace = service.update(contestInPalaceToCompareWith);

        assertEquals(contestInPalace, contestInPalaceToCompareWith);
    }

    @Test
    public void getAll() throws Exception {
        List<ContestInPalace> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, contestInPalaceList);
    }

}