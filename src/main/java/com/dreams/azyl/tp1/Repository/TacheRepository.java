package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.Tache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "taches")
public interface TacheRepository extends CrudRepository<Tache, Long> {
    List<Tache> findByUtilisateurId(Long utilisateurId);
}