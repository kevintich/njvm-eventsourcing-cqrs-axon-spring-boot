package com.njvm.es.cqrsaxonspringboot.entities.handlers;

import com.njvm.es.cqrsaxonspringboot.aggregates.CustomerAggregate;
import com.njvm.es.cqrsaxonspringboot.entities.CustomerQueryEntity;
import com.njvm.es.cqrsaxonspringboot.entities.repositories.CustomerRepository;
import com.njvm.es.cqrsaxonspringboot.events.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerQueryEntityManager {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    @Qualifier("customerAggregateEventSourcingRepository")
    private EventSourcingRepository<CustomerAggregate> customerAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event){
        persistCustomer(buildQueryCustomer(getCustomerFromEvent(event)));
    }


    private CustomerAggregate getCustomerFromEvent(BaseEvent event){
        return customerAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private CustomerQueryEntity findExistingOrCreateQueryCustomer(String id){
        return customerRepository.findById(id).isPresent() ?
                customerRepository.findById(id).get() : new CustomerQueryEntity();
    }

    private CustomerQueryEntity buildQueryCustomer(CustomerAggregate customerAggregate){
        CustomerQueryEntity customerQueryEntity =
                findExistingOrCreateQueryCustomer(customerAggregate.getId());

        customerQueryEntity.setId(customerAggregate.getId());
        customerQueryEntity.setFirstName(customerAggregate.getFirstName());
        customerQueryEntity.setLastName(customerAggregate.getLastName());

        return customerQueryEntity;
    }

    private void persistCustomer(CustomerQueryEntity customerQueryEntity){
        customerRepository.save(customerQueryEntity);
    }
}
