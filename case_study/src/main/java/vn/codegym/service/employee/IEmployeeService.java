package vn.codegym.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable);
    Employee saveEmployee(Employee employee);
    Employee findByIdEmployee(Integer id);
    Page<Employee> seachEmployee(String employeeName ,
                                 String employeeAdress ,
                                 String position,
                                 String educationDegree,
                                 String division,
                                 Pageable pageable);

    void deleteByEmployeeId(int id);
}
