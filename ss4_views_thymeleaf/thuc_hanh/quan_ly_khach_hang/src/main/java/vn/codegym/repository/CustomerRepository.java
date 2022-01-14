package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;

import java.util.*;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final Map<Integer, Customer> customerList;

    static {
        customerList = new TreeMap<>();
        customerList.put(1, new Customer(1, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(2, new Customer(2, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(3, new Customer(3, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(4, new Customer(4, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(5, new Customer(5, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(6, new Customer(6, "Tai", "Nam Phuoc", "Quang Nam"));
        customerList.put(7, new Customer(7, "Tai", "Nam Phuoc", "Quang Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public Customer findById(int id) {
        for (Map.Entry<Integer, Customer> entry : customerList.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(int id) {
            customerList.remove(id);
    }

    @Override
    public void editCustomer(int id ,Customer customer) {
            customerList.put(id,customer);
    }
}
