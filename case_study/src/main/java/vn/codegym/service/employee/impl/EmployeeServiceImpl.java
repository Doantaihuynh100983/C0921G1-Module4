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
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findByIdEmployee(Integer id) {
        return iEmployeeRepository.findById(id);
    }
}
