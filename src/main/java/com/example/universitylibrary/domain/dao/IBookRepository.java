package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Author;
import com.example.universitylibrary.domain.models.Book;
import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {
    @Query("SELECT u FROM Book u")
    List<Book> showAllBooks();
    @Query(
            value = "SELECT Genre.name FROM Genre JOIN Books On Genre.id = Books.id",
            nativeQuery = true
    )
    List<String> listGenre();
    @Query(
            value = "SELECT Publish.name FROM Publish JOIN Books On Publish.id = Books.id",
            nativeQuery = true
    )
    List<String> getPublish();



}
