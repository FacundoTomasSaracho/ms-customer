package org.example.mscustomer.business.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mscustomer.business.model.ClientType;
import org.example.mscustomer.business.model.Customer;
import org.example.mscustomer.business.service.CustomerService;
import org.example.mscustomer.config.mappers.CustomerMapper;
import org.example.mscustomer.persistence.mysql.entity.CustomerEntity;
import org.example.mscustomer.persistence.mysql.service.CustomerRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryService customerRepositoryService;

    @Override
    public List<Customer> findAll() {
        return CustomerMapper.INSTANCE.entityToModel(customerRepositoryService.findAll());
    }

    @Override
    public Customer findById(Long id) {
        return CustomerMapper.INSTANCE.entityToModel(customerRepositoryService.findById(id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerRepositoryService.createCustomer(CustomerMapper.INSTANCE.modelToEntity(customer));
        log.info("Customer created. Data: [{}]", customerEntity);
        return CustomerMapper.INSTANCE.entityToModel(customerEntity);
    }

}
