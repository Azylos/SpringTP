package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.Tache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tache")
public interface TacheRepository extends CrudRepository<Tache, Long> {
}