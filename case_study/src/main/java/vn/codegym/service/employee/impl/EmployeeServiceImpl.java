package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.employee.IEmployeeRepository;
import vn.codegym.service.employee.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findByIdEmployee(Integer id) {
        return iEmployeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public Page<Employee> seachEmployee(String employeeName,
                                        String employeeAdress,
                                        String position,
                                        String educationDegree,
                                        String division,
                                        Pageable pageable) {
        return iEmployeeRepository.searchEmployee(employeeName,employeeAdress,position,educationDegree,division,pageable);
    }

    @Override
    public void deleteByEmployeeId(int id) {
            iEmployeeRepository.deleteByEmployeeId(id);
    }

}
