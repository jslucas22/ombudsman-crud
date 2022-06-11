package com.crud.sbcrud.service;

import com.crud.sbcrud.model.Tag;
import com.crud.sbcrud.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private ITagRepository repository;

    public void gravarTag(Tag tag) {
        repository.save(tag);
    }

    public List<Tag> listarTag() {
        return repository.findAll();
    }

    public Tag obterTagPorId(int id) {
        Optional<Tag> tag = repository.findById(id);

        if ((tag.isPresent()))
            return tag.get();

        return null;
    }

    public void removerTagPorId(int id) {
        repository.deleteById(id);
    }
}
