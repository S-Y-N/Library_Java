package com.example.universitylibrary.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "departments", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Departament implements Serializable {
    @Id
    @Column(name = "id")
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Getter
    @OneToMany(mappedBy = "departament")
    private Set<Teacher> teachers;

    public  Departament(int depart_id){
        this.id=depart_id;
    }

    public Departament() {}

    public Set<Teacher> getTeachers(){return  teachers;}

}
