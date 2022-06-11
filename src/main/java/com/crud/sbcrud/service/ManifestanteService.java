package com.crud.sbcrud.service;

import com.crud.sbcrud.model.Manifestante;
import com.crud.sbcrud.repository.IManifestanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManifestanteService {
    @Autowired
    private IManifestanteRepository repository;

    public void gravarManifestante(Manifestante manifestante) {
        repository.save(manifestante);
    }

    public List<Manifestante> listarManifestantes() {
        return repository.findAll();
    }

    public Manifestante obterManifestantePorId(int id) {
        Optional<Manifestante> manifestante = repository.findById(id);

        if ((manifestante.isPresent()))
            return manifestante.get();

        return null;
    }

    public long obterQuantidadeManifestantes() {
        return repository.count();
    }

    public void removerManifestantePorId(int id) {
        repository.deleteById(id);
    }
}