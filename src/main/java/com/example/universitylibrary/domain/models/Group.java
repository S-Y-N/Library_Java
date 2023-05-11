package com.example.universitylibrary.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "groups", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Group implements Serializable {
    @Id
    @Column(name = "id")
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "depart_id",nullable = false)
    private Departament departament;

    @Getter
    @Setter
    @OneToMany(mappedBy = "group")
    private Set<Student> students;
}
