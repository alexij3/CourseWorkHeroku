package com.buzilov.lab6crud.repository.impresario;

import com.buzilov.lab6crud.model.Impresario;
import com.buzilov.lab6crud.model.Genre;
import com.buzilov.lab6crud.model.Impresario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpresarioRepository extends JpaRepository<Impresario, Integer> {
    List<Impresario> findAllByGenreSetContaining(@Param("genre") Genre genre);
    List<Impresario> findAllByGenreSetIsNull();
    List<Impresario> findAllByAgeLessThan(@Param("age") int age);
    List<Impresario> findAllByAgeGreaterThanEqual(@Param("age") int age);
    List<Impresario> findAllByExperienceLessThan(@Param("experience") int experience);
    List<Impresario> findAllByExperienceGreaterThanEqual(@Param("experience") int experience);
}
