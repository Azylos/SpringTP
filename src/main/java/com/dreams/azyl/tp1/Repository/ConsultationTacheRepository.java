package com.dreams.azyl.tp1.Repository;

import com.dreams.azyl.tp1.Entity.ConsultationTache;
import com.dreams.azyl.tp1.Entity.ConsultationTacheId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "consultationTache")
public interface ConsultationTacheRepository extends CrudRepository<ConsultationTache, ConsultationTacheId> {
    List<ConsultationTache> findByUtilisateurId(Long utilisateurId);
}