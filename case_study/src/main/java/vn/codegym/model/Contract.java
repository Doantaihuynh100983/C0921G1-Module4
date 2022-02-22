package vn.codegym.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private Date contractStartDate;
    private Date contrachEndDate;
    private double contractDeposit;
    private double contractTotalMoney;


    @ManyToOne
    @JoinColumn(name = "employeeId" ,referencedColumnName =  "employeeId")
    private Employee employeeId;


    @OneToMany(mappedBy = "contractId")
    private List<ContractDetail> contractDetails;


    @ManyToOne
    @JoinColumn(name = "customerId" ,referencedColumnName =  "customerId")
    private Customer customerId;


    @ManyToOne
    @JoinColumn(name = "serviceId" ,referencedColumnName =  "serviceId")
    private Service serviceId;

    public Contract() {
    }


    public Contract(int contractId, Date contractStartDate, Date contrachEndDate, double contractDeposit, double contractTotalMoney,
                    Employee employeeId, List<ContractDetail> contractDetails) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contrachEndDate = contrachEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.contractDetails = contractDetails;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContrachEndDate() {
        return contrachEndDate;
    }

    public void setContrachEndDate(Date contrachEndDate) {
        this.contrachEndDate = contrachEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
}
