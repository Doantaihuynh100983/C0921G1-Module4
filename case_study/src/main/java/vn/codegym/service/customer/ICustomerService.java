package vn.codegym.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> getAllCustomer(Pageable pageable);
    void saveCustomer(Customer customer);
    Customer findById(Integer id);
    void deleteCustomer(Integer id);
    Page<Customer> searchCustomer(String name ,String adress , String customerTypeId,  Pageable pageable);

}
