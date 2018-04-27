package com.buzilov.lab6crud.dao.artist;

import com.buzilov.lab6crud.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ArtistDAO extends CrudRepository<Artist, Integer> {
}
