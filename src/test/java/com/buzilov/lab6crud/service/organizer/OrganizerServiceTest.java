package com.buzilov.lab6crud.service.organizer;

import com.buzilov.lab6crud.model.Organizer;
import com.buzilov.lab6crud.repository.organizer.OrganizerRepository;
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
public class OrganizerServiceTest {
    @Mock
    private OrganizerRepository repository;

    @InjectMocks
    private OrganizerServiceImpl service;

    private List<Organizer> organizerList;

    private Organizer organizerToCompareWith;

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