package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.EducationDegree;

public interface IEducationRepository extends JpaRepository<EducationDegree,Integer> {
}
