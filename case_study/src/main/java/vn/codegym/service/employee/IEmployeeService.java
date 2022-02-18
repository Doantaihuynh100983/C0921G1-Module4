package vn.codegym.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable);
    Employee saveEmployee(Employee employee);
    Optional<Employee> findByIdEmployee(Integer id);


}
