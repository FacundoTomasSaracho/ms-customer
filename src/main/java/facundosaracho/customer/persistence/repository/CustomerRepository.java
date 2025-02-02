package facundosaracho.customer.persistence.repository;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.persistence.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findCustomerById(Long id);
}
