package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Student;
import com.example.universitylibrary.domain.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
}

