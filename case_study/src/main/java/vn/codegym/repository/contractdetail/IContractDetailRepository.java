package vn.codegym.repository.contractdetail;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.ContractDetail;

@Repository
@Transactional
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
