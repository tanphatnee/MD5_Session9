package ra.session5_springboot.service;

import ra.session5_springboot.exception.UserException;
import ra.session5_springboot.model.dto.request.CustomerRequest;
import ra.session5_springboot.model.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService{
    List<CustomerResponse> findAll();
    CustomerResponse findById(Long id);
    CustomerResponse save(CustomerRequest customerRequest) throws UserException;
    CustomerResponse update(CustomerRequest customerRequest,Long id);
    CustomerResponse delete(Long id);

}
