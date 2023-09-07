package ra.session5_springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session5_springboot.exception.UserException;
import ra.session5_springboot.model.domain.Customer;
import ra.session5_springboot.model.dto.request.CustomerRequest;
import ra.session5_springboot.model.dto.response.CustomerResponse;
import ra.session5_springboot.repository.ICustomerRepository;
import ra.session5_springboot.service.ICustomerService;
import ra.session5_springboot.service.mapper.CustomerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream()
                .map(c->customerMapper.toResponse(c))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            return customerMapper.toResponse(customerOptional.get());
        }
        return null;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) throws UserException{
        // check trung
        if (customerRepository.existsByEmail(customerRequest.getEmail())){
            throw new UserException("Email is exists");
        }
        if (customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())){
            throw new UserException("Phone is exists");
        }
        Customer cus = customerRepository.save(customerMapper.toEntity(customerRequest));
        return customerMapper.toResponse(cus);
    }

    @Override
    public CustomerResponse delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            customerRepository.deleteById(id);
            return customerMapper.toResponse(customerOptional.get());
        }
        return null;
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Customer customer = customerMapper.toEntity(customerRequest);
        customer.setId(id);
        return customerMapper.toResponse(customerRepository.save(customer));
    }
}
