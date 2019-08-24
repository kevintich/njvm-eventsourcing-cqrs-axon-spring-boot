package com.njvm.es.cqrsaxonspringboot.config;

import com.njvm.es.cqrsaxonspringboot.aggregates.CustomerAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {


    @Bean
    EventSourcingRepository<CustomerAggregate> customerAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<CustomerAggregate> repository = EventSourcingRepository.builder(CustomerAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
