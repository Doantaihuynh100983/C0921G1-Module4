package vn.codegym.dto;

import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Service;

public class ContractDto {
    private int contractId;
    private String contractStartDate;
    private String contrachEndDate;
    private double contractDeposit;
    private double contractTotalMoney;
    private Employee employeeId;
    private Customer customerId;
    private Service serviceId;

    public ContractDto() {
    }

    public ContractDto(int contractId, String contractStartDate, String contrachEndDate, double contractDeposit,
                       double contractTotalMoney, Employee employeeId, Customer customerId, Service serviceId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contrachEndDate = contrachEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContrachEndDate() {
        return contrachEndDate;
    }

    public void setContrachEndDate(String contrachEndDate) {
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
}
