package com.njvm.es.cqrsaxonspringboot.events;

public class CustomerAccountCreatedEvent extends BaseEvent<String> {

    public final String firstName;
    public final String lastName;

    public CustomerAccountCreatedEvent(String id,String firstName,String lastName ) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
