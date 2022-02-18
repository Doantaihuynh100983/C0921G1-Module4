package vn.codegym.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    void deleteByCustomerId(Integer id);


    @Query(value="SELECT * FROM  Customer where customer_name like %:customerName%  and  customer_address like %:customerAdress%", nativeQuery=true)
    Page<Customer> searchCustomer(@Param("customerName") String customerName,  @Param("customerAdress") String customerAdress,Pageable pagle);
}
