package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.TacheComplexe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tacheComplexe")
public interface TacheComplexeRepository extends CrudRepository<TacheComplexe, Long> {
}