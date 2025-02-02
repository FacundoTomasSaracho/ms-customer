package facundosaracho.customer.presentation.controller;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.business.service.CustomerService;
import facundosaracho.customer.presentation.api.CustomerApi;
import facundosaracho.customer.presentation.dto.CustomerDto;
import facundosaracho.customer.presentation.mapper.CustomerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
@Slf4j
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @PostMapping("create")
    ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {

        log.info("<<< Starting to create customer: {} >>>", customerDto);

        Customer customer = customerService.createCustomer(CustomerMapper.INSTANCE.toModel(customerDto));

        log.info("<<< Customer created successfully >>>");

        return new ResponseEntity<>(CustomerMapper.INSTANCE.toDto(customer), HttpStatus.CREATED);
    }

}
