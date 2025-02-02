package facundosaracho.customer.persistence.repository.impl;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.persistence.JpaCustomerRepository;
import facundosaracho.customer.persistence.repository.CustomerRepository;
import facundosaracho.customer.presentation.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Optional<Customer> findCustomerById(Long id) {

        log.info("Finding client in DB with id: {}", id);

        return jpaCustomerRepository.findById(id).map(CustomerMapper.INSTANCE::fromEntityToModel);
    }
}
