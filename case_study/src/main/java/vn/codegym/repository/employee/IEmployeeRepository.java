package vn.codegym.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Division;
import vn.codegym.model.EducationDegree;
import vn.codegym.model.Employee;
import vn.codegym.model.Position;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Modifying
    @Query(value = "UPDATE employee SET flag_delete_employee = 0 WHERE  employee_id = :employee_id " ,nativeQuery=true)
    void deleteByEmployeeId(@Param("employee_id") int id);


    @Query(value="select * from employee where employee_name like %:employeeName% and employee_adress like %:employeeAdress%  and position_id like %:position% and education_degreeid like %:educationDegree% and division_id like %:division% and flag_delete_employee = 1" ,nativeQuery=true)
    Page<Employee> searchEmployee(@Param("employeeName") String employeeName ,
                                  @Param("employeeAdress")String employeeAdress ,
                                  @Param("position") String position,
                                  @Param("educationDegree") String educationDegree,
                                  @Param("division") String division,
                                  Pageable pageable);
}

