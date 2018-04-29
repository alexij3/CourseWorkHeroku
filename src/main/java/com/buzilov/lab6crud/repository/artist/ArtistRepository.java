package com.buzilov.lab6crud.repository.artist;

import com.buzilov.lab6crud.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
