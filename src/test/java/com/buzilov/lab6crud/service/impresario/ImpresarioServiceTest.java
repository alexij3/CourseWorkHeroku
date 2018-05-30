package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.repository.impresario.ImpresarioRepository;
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
public class ImpresarioServiceTest {
    @Mock
    private ImpresarioRepository repository;

    @InjectMocks
    private ImpresarioServiceImpl service;

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

        Mockito.when(repository.findAll()).thenReturn(impresarioList);
        Mockito.when(repository.save(impresarioToCompareWith)).thenReturn(impresarioToCompareWith);

    }

    @Test
    public void getAll() throws Exception {
        List<Impresario> listToCompareWith = service.getAll();

        assertEquals(listToCompareWith, impresarioList);
    }

    @Test
    public void insertImpresario() throws Exception {
        Impresario impresario = service.insert(impresarioToCompareWith);

        assertEquals(impresario, impresarioToCompareWith);
    }

    @Test
    public void getImpresario() throws Exception {
        int idToFind = 1;

        Impresario expectedImpresario = new Impresario("Some");
        Mockito.when(repository.findById(idToFind)).thenReturn(Optional.of(expectedImpresario));

        Impresario impresario = service.get(idToFind);
        Assert.assertEquals(expectedImpresario, impresario);
    }

    @Test
    public void updateImpresario() throws Exception {
        Impresario impresario = service.update(impresarioToCompareWith);

        assertEquals(impresario, impresarioToCompareWith);
    }

}