package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.CustomerType;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
