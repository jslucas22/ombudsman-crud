package com.crud.sbcrud.repository;

import com.crud.sbcrud.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {
}
