package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public void editCustomer(int id, Customer customer) {
        iCustomerRepository.editCustomer(id,customer);
    }
}
