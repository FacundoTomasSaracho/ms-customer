package org.example.mscustomer.persistence.mysql.service;

import org.example.mscustomer.persistence.mysql.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepositoryService {

    List<CustomerEntity> findAll();

    CustomerEntity findById(Long id);

    CustomerEntity createCustomer(CustomerEntity customerEntity);
}
