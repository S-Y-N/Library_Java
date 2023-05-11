package com.example.universitylibrary.domain.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name ="publish", indexes = {
        @Index(name ="name_index", columnList = "name",unique = true)
})
public class Publish implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "publish")
    private Set<Book> books;

    //getters
    public String getName(){return name;}
    public Set<Book> getBooks(){return books;}

    //setters
    public void setName(String name){this.name = name;}
}
