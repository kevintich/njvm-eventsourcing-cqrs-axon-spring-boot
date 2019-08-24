package com.njvm.es.cqrsaxonspringboot.services.commands;

import com.njvm.es.cqrsaxonspringboot.commands.CreateCustomerCommand;
import com.njvm.es.cqrsaxonspringboot.dto.commands.CustomerCreateDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final CommandGateway commandGateway;

    public CustomerCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> registerCustomer(CustomerCreateDTO customerCreateDTO) {
        return commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),customerCreateDTO.getFirstName()
                ,customerCreateDTO.getLastName()));
    }


}
