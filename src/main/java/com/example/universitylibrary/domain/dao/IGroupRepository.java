package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Group;
import com.example.universitylibrary.domain.models.Librarian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepository extends CrudRepository<Group, Long> {

    @Query("select a from Group a")
    List<Group> showGroup();

    @Query(
            value = "SELECT departments.name FROM departments JOIN groups on departments.id = groups.id GROUP BY name",
            nativeQuery = true)
    List<String> getDeparts();
}


