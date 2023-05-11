package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Librarian;
import com.example.universitylibrary.domain.models.Publish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrarianRepository extends CrudRepository<Librarian, Long> {
}

