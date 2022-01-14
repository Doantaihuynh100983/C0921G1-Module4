package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    void editCustomer(int id , Customer customer);
}
