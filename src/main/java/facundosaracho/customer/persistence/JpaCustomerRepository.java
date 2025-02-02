package facundosaracho.customer.persistence;

import facundosaracho.customer.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
