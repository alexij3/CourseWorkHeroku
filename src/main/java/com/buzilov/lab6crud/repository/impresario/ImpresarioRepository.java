package com.buzilov.lab6crud.repository.impresario;

import com.buzilov.lab6crud.model.Impresario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpresarioRepository extends CrudRepository<Impresario, Integer> {

}
