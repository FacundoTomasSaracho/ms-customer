package org.example.mscustomer.config.mappers;

import org.example.mscustomer.business.model.Customer;
import org.example.mscustomer.persistence.mysql.entity.CustomerEntity;
import org.example.mscustomer.presentation.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE  = Mappers.getMapper(CustomerMapper.class);

    Customer entityToModel(CustomerEntity customerEntity);
    CustomerDto modelToDto(Customer customer);
    Customer dtoToModel(CustomerDto customerDto);
    CustomerEntity modelToEntity(Customer customer);

    List<Customer> entityToModel(List<CustomerEntity> customerEntity);
    List<CustomerDto> modelToDto (List<Customer> customers);
 }
