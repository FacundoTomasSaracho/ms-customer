package facundosaracho.customer.business.service.impl;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.business.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }
}
