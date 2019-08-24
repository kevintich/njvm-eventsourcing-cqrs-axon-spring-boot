package com.njvm.es.cqrsaxonspringboot.aggregates;

import com.njvm.es.cqrsaxonspringboot.commands.CreateCustomerCommand;
import com.njvm.es.cqrsaxonspringboot.events.CustomerAccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CustomerAggregate {

    @AggregateIdentifier
    private String id;


    private String firstName;
    private String lastName;


    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand){

        AggregateLifecycle.apply(new CustomerAccountCreatedEvent(createCustomerCommand.id,
                createCustomerCommand.firstName, createCustomerCommand.lastName));
    }

    @EventSourcingHandler
    protected void on(CustomerAccountCreatedEvent customerAccountCreatedEvent){
        this.id = customerAccountCreatedEvent.id;
        this.firstName = customerAccountCreatedEvent.firstName;
        this.lastName = customerAccountCreatedEvent.lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
