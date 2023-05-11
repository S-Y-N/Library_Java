package com.example.universitylibrary.domain.dao;

import com.example.universitylibrary.domain.models.SCard;
import com.example.universitylibrary.domain.models.TCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISCardRepository extends CrudRepository<SCard, Long> {
}
