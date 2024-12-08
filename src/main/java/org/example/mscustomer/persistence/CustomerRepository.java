package org.example.mscustomer.persistence;

import org.example.mscustomer.persistence.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
