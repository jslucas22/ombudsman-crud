package com.crud.sbcrud.repository;

import com.crud.sbcrud.model.ManifestacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IManifestacaoRepository extends JpaRepository<ManifestacaoModel, Integer> {
/*
*  " +
            "inner join Manifestante     as m2 on m1.manifestante.id = m2.id " +
            "inner join Manifestado      as m3 on m1.manifestado.id = m3.id " +
            "inner join TipoManifestacao as t1 on m1.tipoManifestacao.id = t1.id " +
            "inner join Tag              as t2 on m1.tag.id = t2.id
* */
    @Query(value = "SELECT manifestacao.id, manifestacao.manifestacao, manifestante.id as manifestante_id, manifestacao.manifestado_id, manifestacao.tag_id, manifestacao.tipo_manifestacao_id from ouvidoria_manifestacao manifestacao join ouvidoria_manifestante as manifestante on manifestacao.manifestante_id = manifestante.id order by manifestacao.id desc", nativeQuery = true)
    public List<ManifestacaoModel> listarManifestacoes();
}
