package org.example.mscustomer.persistence.mysql.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mscustomer.persistence.CustomerRepository;
import org.example.mscustomer.persistence.mysql.entity.CustomerEntity;
import org.example.mscustomer.persistence.mysql.service.CustomerRepositoryService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryServiceImpl implements CustomerRepositoryService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
}
