package com.njvm.es.cqrsaxonspringboot.services.queries;

import com.njvm.es.cqrsaxonspringboot.entities.CustomerQueryEntity;
import com.njvm.es.cqrsaxonspringboot.entities.repositories.CustomerRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

    private final EventStore eventStore;

    private final CustomerRepository customerRepository;

    public CustomerQueryServiceImpl(EventStore eventStore,
                                    CustomerRepository customerRepository) {
        this.eventStore = eventStore;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerQueryEntity getCustomer(String customerId) {
        return customerRepository.findById(customerId).get();
    }


    @Override
    public List<Object> listEventsForCustomer(String customerId) {
        return eventStore.readEvents(customerId).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

}
