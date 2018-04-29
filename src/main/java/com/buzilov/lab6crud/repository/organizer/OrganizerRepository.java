package com.buzilov.lab6crud.repository.organizer;

import com.buzilov.lab6crud.model.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {

}
