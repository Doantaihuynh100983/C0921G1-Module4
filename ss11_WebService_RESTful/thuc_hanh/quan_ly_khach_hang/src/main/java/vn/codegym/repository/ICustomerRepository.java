package vn.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.model.Customer;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
