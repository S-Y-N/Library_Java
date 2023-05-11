package com.example.universitylibrary.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books", indexes = {
    @Index(name = "name_index",columnList = "name", unique = true)
})
public class Book implements Serializable {

    //Властивості книги ід, назва, опис до книги, рік, к-ть сторінок
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 64, nullable = false)
    private String name;
    @Column(name = "description", length = 255, nullable = true)
    private String description;
    @Column(name = "year", nullable = true)
    private int year;
    @Column(name = "pages", nullable = true)
    private int pages;

    //Інші параметри це відношення
    //Окрема табилця для наз жанрів, щоб не було дубляжу, відношеня МОТ
    //Книг багато одного жанру
    //Додаємо колонку з номером жанру
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true)
    private Genre genre;

    //Так само з видавництвом
    @ManyToOne
    @JoinColumn(name="publish_id",nullable = false)
    private Publish publish;

    //Відношення книга - людина,
    //Одна книга в руки, але таких рук може бути багато
    //Вертаємо множество, можна і список студентів і викладачів
    @OneToMany(mappedBy = "book")
    private Set<SCard> sCards;

    @OneToMany(mappedBy = "book")
    private Set<TCard> tCards;

    @ManyToMany
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    public String getName(){return  name;}
    public int getPages(){return  pages;}
    public int getYear(){return  year;}
    public String getDescription(){return  description;}
    public Genre getGenre(){return genre;}
    public Publish getPublish(){return publish;}
}
