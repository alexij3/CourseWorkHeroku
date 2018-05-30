package com.buzilov.lab6crud.service.impresario;

import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.repository.impresario.ImpresarioRepository;
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
public class ImpresarioServiceTest {
    @Mock
    private ImpresarioRepository repository;

    @InjectMocks
    private ImpresarioServiceImpl service;

    private List<Impresario> impresarioList;

    private Impresario impresarioToCompareWith;

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