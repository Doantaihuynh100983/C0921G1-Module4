package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;

public class CustomerService implements  ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
