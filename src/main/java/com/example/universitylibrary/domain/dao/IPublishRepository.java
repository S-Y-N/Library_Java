package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.Publish;
import com.example.universitylibrary.domain.models.SCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublishRepository extends CrudRepository<Publish, Long> {
}
