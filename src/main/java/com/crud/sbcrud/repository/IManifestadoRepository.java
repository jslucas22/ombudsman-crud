package com.crud.sbcrud.repository;

import com.crud.sbcrud.model.Manifestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManifestadoRepository extends JpaRepository<Manifestado, Integer> {
}
