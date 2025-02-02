package facundosaracho.customer.business.service.impl;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.business.service.CustomerService;
import facundosaracho.customer.persistence.repository.CustomerRepository;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {

        return customerRepository.findCustomerById(id).orElseThrow(PersistenceException::new);
    }
}
