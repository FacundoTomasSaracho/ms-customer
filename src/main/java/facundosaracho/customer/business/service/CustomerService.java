package facundosaracho.customer.business.service;

import facundosaracho.customer.business.model.Customer;

public interface CustomerService {

    Customer findById(Long id);
}
