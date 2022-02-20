package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.EducationDegree;

@Repository
@Transactional
public interface IEducationRepository extends JpaRepository<EducationDegree,Integer> {
}
