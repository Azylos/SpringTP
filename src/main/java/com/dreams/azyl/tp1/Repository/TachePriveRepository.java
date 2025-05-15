package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.TachePrive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tachePrive")
public interface TachePriveRepository extends CrudRepository<TachePrive, Long> {
}