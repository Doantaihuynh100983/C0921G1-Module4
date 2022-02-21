package vn.codegym.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Contract;

@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
