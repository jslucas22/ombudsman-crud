package com.crud.sbcrud.repository;

import com.crud.sbcrud.model.Manifestante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManifestanteRepository extends JpaRepository<Manifestante, Integer> {
}
