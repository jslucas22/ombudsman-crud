package com.crud.sbcrud.service;

import com.crud.sbcrud.model.TipoManifestacao;
import com.crud.sbcrud.repository.ITipoManifestacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoManifestacaoService {

    @Autowired
    private ITipoManifestacaoRepository repository;

    public void gravarTipoManifestacao(TipoManifestacao tipoManifestacao) {
        repository.save(tipoManifestacao);
    }

    public List<TipoManifestacao> listarTipoManifestacao() {
        return repository.findAll();
    }

    public TipoManifestacao obterTipoManifestacaoPorId(int id) {
        Optional<TipoManifestacao> tipoManifestacao = repository.findById(id);

        if ((tipoManifestacao.isPresent()))
            return tipoManifestacao.get();

        return null;
    }

    public void removerTipoManifestacaoPorId(int id) {
        repository.deleteById(id);
    }
}
