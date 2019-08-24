package com.njvm.es.cqrsaxonspringboot.controllers;

import com.njvm.es.cqrsaxonspringboot.entities.CustomerQueryEntity;
import com.njvm.es.cqrsaxonspringboot.services.queries.CustomerQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@Api(value = "Customer Queries", description = "Customer Query Events Endpoint",
        tags = "Customer Queries")
public class CustomerQueryController {

    private final CustomerQueryService customerQueryService;

    public CustomerQueryController(CustomerQueryService customerQueryService) {
        this.customerQueryService = customerQueryService;
    }

    @GetMapping("/{customerId}")
    public CustomerQueryEntity getCustomer(@PathVariable(value = "customerId") String customerId){
        return customerQueryService.getCustomer(customerId);
    }
    @GetMapping("/{customerId}/events")
    public List<Object> listEventsForCustomer(@PathVariable(value =
"customerId") String customerId){
        return customerQueryService.listEventsForCustomer(customerId);
    }


}
