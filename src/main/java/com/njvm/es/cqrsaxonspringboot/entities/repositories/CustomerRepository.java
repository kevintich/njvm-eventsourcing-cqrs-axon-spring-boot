package com.njvm.es.cqrsaxonspringboot.entities.repositories;

import com.njvm.es.cqrsaxonspringboot.entities.CustomerQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerQueryEntity, String> {
}
