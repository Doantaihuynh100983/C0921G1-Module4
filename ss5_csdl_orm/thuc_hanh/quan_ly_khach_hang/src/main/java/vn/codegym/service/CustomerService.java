package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
            iCustomerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
            iCustomerRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }
}
