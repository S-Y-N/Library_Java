package com.example.universitylibrary.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teachers", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
public class Teacher implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name", length = 64, nullable = false)
    private String lastName;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "depart_id", nullable = true)
    private Departament departament;



    @OneToMany(mappedBy = "teacher")
    private Set<TCard> tCards;
}
