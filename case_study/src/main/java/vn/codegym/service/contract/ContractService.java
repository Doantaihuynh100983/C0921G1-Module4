package vn.codegym.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.repository.contract.IContractRepository;
import vn.codegym.service.customer.ICustomerService;

import java.util.List;

@Service
public class ContractService implements IContractService{
    @Autowired
    IContractRepository iContractRepository;
    @Autowired
    ICustomerService iCustomerService;
    @Override
    public List<Contract> getAllContract() {
        return iContractRepository.findAll();
    }

    @Override
    public void addContract(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findByIdContract(Integer id) {
        return iContractRepository.findById(id).orElse(new Contract());
    }
}
