package com.btgpactual.ordens.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.btgpactual.ordens.domain.entity.Ordens;

@Repository
public interface OrdensRepository extends MongoRepository<Ordens, Long>{

}
