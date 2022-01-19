package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(Long id);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
