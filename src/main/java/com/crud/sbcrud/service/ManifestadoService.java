package com.crud.sbcrud.service;

import com.crud.sbcrud.model.Manifestado;
import com.crud.sbcrud.repository.IManifestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManifestadoService {
    @Autowired
    private IManifestadoRepository repository;

    public void gravarManifestado(Manifestado manifestado) {
        repository.save(manifestado);
    }

    public List<Manifestado> listarManifestados() {
        return repository.findAll();
    }

    public Manifestado obterManifestadoPorId(int id) {
        Optional<Manifestado> manifestado = repository.findById(id);

        if ((manifestado.isPresent()))
            return manifestado.get();

        return null;
    }

    public long obterQuantidadeManifestados() {
        return repository.count();
    }

    public void removerManifestadoPorId(int id) {
        repository.deleteById(id);
    }
}
