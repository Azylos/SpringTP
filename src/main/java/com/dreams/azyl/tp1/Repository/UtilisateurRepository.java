package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "utilisateurs")
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
}