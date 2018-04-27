package com.buzilov.lab6crud.dao.organizer;

import com.buzilov.lab6crud.model.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface OrganizerDAO extends CrudRepository<Organizer, Integer> {

}
