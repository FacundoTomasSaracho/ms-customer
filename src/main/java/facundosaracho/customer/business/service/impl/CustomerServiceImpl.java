package facundosaracho.customer.business.service.impl;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.business.service.CustomerService;
import facundosaracho.customer.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Long id) {

        return customerRepository.findCustomerById(id);
    }
}
