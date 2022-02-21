package vn.codegym.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> getAllContract();
    void addContract(Contract contract);
    Contract findByIdContract(Integer id);

}
