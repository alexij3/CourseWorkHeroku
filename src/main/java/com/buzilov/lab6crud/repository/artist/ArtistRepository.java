package com.buzilov.lab6crud.repository.artist;

import com.buzilov.lab6crud.model.Artist;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findAllByGenreSetContaining(@Param("genre") Genre genre);
    List<Artist> findArtistByImpresariosContaining(@Param("impresario") Impresario impresario);

    @Query("SELECT a FROM Artist a WHERE a.id NOT IN (SELECT b FROM Artist b JOIN b.contestResults c WHERE c.contest.date BETWEEN :firstDate AND :secondDate)")
    List<Artist> findAllByContestDateNotBetween(@Param("firstDate") LocalDate firstDate,
                                                @Param("secondDate") LocalDate secondDate);

    List<Artist> findAllByGenreSetIsNull();

}
