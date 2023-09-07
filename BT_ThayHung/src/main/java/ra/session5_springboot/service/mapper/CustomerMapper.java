package ra.session5_springboot.service.mapper;

import org.springframework.stereotype.Component;
import ra.session5_springboot.model.domain.Customer;
import ra.session5_springboot.model.dto.request.CustomerRequest;
import ra.session5_springboot.model.dto.response.CustomerResponse;
import ra.session5_springboot.service.IGenericMapper;

@Component
public class CustomerMapper implements IGenericMapper<Customer, CustomerRequest, CustomerResponse> {
    @Override
    public Customer toEntity(CustomerRequest customerRequest) {
        return Customer.builder().fullName(customerRequest.getFullName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .age(customerRequest.getAge())
                .sex(customerRequest.isSex())
                .build();
    }

    @Override
    public CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder().id(customer.getId())
                .sex(customer.isSex())
                .age(customer.getAge())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .phoneNumber(customer.getPhoneNumber()).build();
    }
}
