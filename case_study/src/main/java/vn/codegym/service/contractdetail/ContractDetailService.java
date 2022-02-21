package vn.codegym.service.contractdetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.contractdetail.IContractDetailRepository;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> getAllContractDetail() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findByIdContractDetail(Integer id) {
        return iContractDetailRepository.findById(id).orElse(new ContractDetail());
    }

    @Override
    public void addContractDetail(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

}
