package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {


}
