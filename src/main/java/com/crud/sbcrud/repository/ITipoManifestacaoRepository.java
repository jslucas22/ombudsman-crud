package com.crud.sbcrud.repository;

import com.crud.sbcrud.model.TipoManifestacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoManifestacaoRepository extends JpaRepository<TipoManifestacao, Integer> {
}
