package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Genre;
import com.example.universitylibrary.domain.models.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGenreRepository extends CrudRepository<Genre, Long> {

}
