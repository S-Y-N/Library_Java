package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Author;
import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeacherRepository extends CrudRepository<Teacher, Long> {

    @Query("SELECT u FROM Teacher u")
    List<Teacher> showTeachers();
    @Query(
            value = "SELECT departments.name FROM departments JOIN teachers on departments.id = teachers.id",
            nativeQuery = true)
    List<String> getDeparts();
}
