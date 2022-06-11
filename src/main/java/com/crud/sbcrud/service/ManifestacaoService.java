package com.crud.sbcrud.service;

import com.crud.sbcrud.model.ManifestacaoModel;
import com.crud.sbcrud.repository.IManifestacaoRepository;
import com.crud.sbcrud.repository.IManifestanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManifestacaoService {
    @Autowired
    private IManifestacaoRepository repository;

    @Autowired
    IManifestanteRepository manifesanteRepository;

    public ManifestacaoModel obterManifestacao(int id) {
        Optional<ManifestacaoModel> manifestacao = repository.findById(id);

        if ((manifestacao.isPresent()))
            return manifestacao.get();

        return null;
    }

    public void gravarManifestacao(ManifestacaoModel manifestacaoModel) {
        repository.save(manifestacaoModel);
    }

    public List<ManifestacaoModel> listarManifestacao() {
        return repository.listarManifestacoes();
    }

    public long obterQuantidadeManifestacoes() {
        return repository.count();
    }

    public void removerManifestacaoPorId(int id) {
        repository.deleteById(id);
    }
}
