package vn.codegym.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Division;
import vn.codegym.model.EducationDegree;
import vn.codegym.model.Employee;
import vn.codegym.model.Position;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {


    @Query(value="select * from employee where employee_name like %:employeeName% and employee_adress like %:employeeAdress%  and position_id like %:position% and education_degreeid like %:educationDegree% and division_id like %:division%" ,nativeQuery=true)
    Page<Employee> searchEmployee(@Param("employeeName") String employeeName ,
                                  @Param("employeeAdress")String employeeAdress ,
                                  @Param("position") String position,
                                  @Param("educationDegree") String educationDegree,
                                  @Param("division") String division,
                                  Pageable pageable);
}

