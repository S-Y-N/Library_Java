package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IAuthorRepository  extends CrudRepository<Author, Long> {

    @Query(
            value = "SELECT * FROM Author",
            nativeQuery = true
    )
    List<Author> showAuthors();
}
