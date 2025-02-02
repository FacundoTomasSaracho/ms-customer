package facundosaracho.customer.presentation.mapper;

import facundosaracho.customer.business.model.Customer;
import facundosaracho.customer.persistence.entity.CustomerEntity;
import facundosaracho.customer.presentation.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toModel(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
    Customer fromEntityToModel(CustomerEntity customerEntity);

}
