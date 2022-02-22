package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.customer.ICustomerRepository;
import vn.codegym.service.customer.ICustomerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private  ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteByCustomerId(id);
    }
    @Override
    public Page<Customer> searchCustomer(String name, String adress, String customerType, Pageable pageable) {
        return iCustomerRepository.searchCustomer(name,adress,customerType,pageable);    }


}
