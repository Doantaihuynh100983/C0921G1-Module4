package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.CustomerType;

@Repository
@Transactional
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
