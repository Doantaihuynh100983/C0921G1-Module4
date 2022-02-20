package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Position;


@Repository
@Transactional
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
