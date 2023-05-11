package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Genre;
import com.example.universitylibrary.domain.models.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends CrudRepository<Departament, Long> {
    @Query("select a from Departament a")
    List<Departament> showDepartments();
}
