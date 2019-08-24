package com.njvm.es.cqrsaxonspringboot.controllers;

import com.njvm.es.cqrsaxonspringboot.dto.commands.CustomerCreateDTO;
import com.njvm.es.cqrsaxonspringboot.services.commands.CustomerCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/customers")
@Api(value = "Customer Commands", description = "Customer Command Related " +
        "Endpoints", tags = "Customer Commands")
public class CustomerCommandController {

    private final CustomerCommandService customerCommandService;

    public CustomerCommandController(CustomerCommandService customerCommandService) {
        this.customerCommandService = customerCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createCustomer(@RequestBody CustomerCreateDTO customerCreateDTO){
        return customerCommandService.registerCustomer(customerCreateDTO);
    }

}
