package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Division;

public interface IDivisionRepository  extends JpaRepository<Division,Integer> {
}
