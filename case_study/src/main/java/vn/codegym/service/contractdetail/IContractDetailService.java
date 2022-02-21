package vn.codegym.service.contractdetail;

import vn.codegym.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> getAllContractDetail();
    ContractDetail findByIdContractDetail(Integer id);
    void addContractDetail(ContractDetail contractDetail);
}
