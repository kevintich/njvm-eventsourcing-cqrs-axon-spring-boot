package com.njvm.es.cqrsaxonspringboot.commands;

public class CreateCustomerCommand extends BaseCommand<String> {


    public final String firstName;
    public final String lastName;

    public CreateCustomerCommand(String id, String firstName,String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
