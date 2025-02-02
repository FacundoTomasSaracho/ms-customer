package facundosaracho.customer.presentation.controller;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.business.service.CustomerService;
import facundosaracho.customer.presentation.api.CustomerApi;
import facundosaracho.customer.presentation.dto.CustomerDto;
import facundosaracho.customer.presentation.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
@Slf4j
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @GetMapping("{id}")
    ResponseEntity<CustomerDto> findById(@PathVariable Long id) {

        log.info("Finding client in db with id : {}", id);

        Customer customer = customerService.findById(id);

        log.info("<<< Customer was found successfully. Customer data: {}", customer);

        return new ResponseEntity<>(CustomerMapper.INSTANCE.toDto(customer), HttpStatus.CREATED);
    }

}
