package com.njvm.es.cqrsaxonspringboot.services.commands;

import com.njvm.es.cqrsaxonspringboot.dto.commands.CustomerCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface CustomerCommandService {

    public CompletableFuture<String> registerCustomer(CustomerCreateDTO customerCreateDTO);

}
