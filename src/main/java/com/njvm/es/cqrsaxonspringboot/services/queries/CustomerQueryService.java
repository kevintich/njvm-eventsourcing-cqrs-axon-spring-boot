package com.njvm.es.cqrsaxonspringboot.services.queries;

import com.njvm.es.cqrsaxonspringboot.entities.CustomerQueryEntity;

import java.util.List;

public interface CustomerQueryService {
    public CustomerQueryEntity getCustomer(String customerId);
    public List<Object> listEventsForCustomer(String customerId);

}
