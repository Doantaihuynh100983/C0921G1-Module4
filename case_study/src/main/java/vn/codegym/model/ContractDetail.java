package vn.codegym.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;


    @ManyToOne
    @JoinColumn(name = "contractId" ,referencedColumnName =  "contractId")
    private Contract contractId;


    @ManyToOne
    @JoinColumn(name = "attachServiceId" ,referencedColumnName =  "attachServiceId")
    private AttachService attachServiceId;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, Contract contractId, AttachService attachServiceId) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }
}
