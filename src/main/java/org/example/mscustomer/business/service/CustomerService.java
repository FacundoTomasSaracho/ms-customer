package org.example.mscustomer.business.service;

import org.example.mscustomer.business.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer createCustomer(Customer customer);

}
