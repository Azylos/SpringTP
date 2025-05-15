package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.TacheDeleguee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tacheDeleguee")
public interface TacheDelegueeRepository extends CrudRepository<TacheDeleguee, Long> {
}