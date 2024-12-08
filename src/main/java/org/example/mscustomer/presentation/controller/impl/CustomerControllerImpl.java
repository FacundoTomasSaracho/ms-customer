package org.example.mscustomer.presentation.controller.impl;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.mscustomer.business.model.ClientType;
import org.example.mscustomer.business.service.CustomerService;
import org.example.mscustomer.config.mappers.CustomerMapper;
import org.example.mscustomer.presentation.controller.CustomerControllerApi;
import org.example.mscustomer.presentation.dto.CustomerDto;
import org.example.mscustomer.strategy.client.fabric.ClientFabric;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerControllerImpl implements CustomerControllerApi {

    private final CustomerService customerService;
    private final ClientFabric clientFabric;

    @GetMapping("all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(CustomerMapper.INSTANCE.modelToDto(customerService.findAll()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(CustomerMapper.INSTANCE.modelToDto(customerService.findById(id)), HttpStatus.OK);
    }

    @Override
    @PostMapping("create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return new ResponseEntity<>(CustomerMapper.INSTANCE.modelToDto(customerService.createCustomer(CustomerMapper.INSTANCE.dtoToModel(customerDto))), HttpStatus.CREATED);
    }

    @Override
    @PostMapping("calculate-tax")
    public ResponseEntity<Double> calculateClientTaxes(@RequestBody ClientTax clientTax) {
        return new ResponseEntity<>(clientFabric
                .getStrategy(clientTax.clientType)
                .calculateTax(clientTax.amount), HttpStatus.OK);
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record ClientTax(@NotNull ClientType clientType, @Positive Double amount) {
    }
}

