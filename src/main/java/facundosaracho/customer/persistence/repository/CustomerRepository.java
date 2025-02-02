package facundosaracho.customer.persistence.repository;

import facundosaracho.customer.business.model.Customer;

public interface CustomerRepository {

    Customer findCustomerById(Long id);
}
