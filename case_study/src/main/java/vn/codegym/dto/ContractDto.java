package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Service;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class ContractDto implements Validator {
    private int contractId;

    private Date contractStartDate;

    private Date contrachEndDate;

    @NotNull(message = "Do not use spaces !!!")
    private Double contractDeposit;


    @NotNull(message = "Do not use spaces !!!")
    private Double contractTotalMoney;


    @NotNull(message = "Mandatory Choose !!")
    private Employee employeeId;

    @NotNull(message = "Mandatory Choose !!")
    private Customer customerId;


    @NotNull(message = "Mandatory Choose !!")
    private Service serviceId;

    public ContractDto() {
    }

    public ContractDto(int contractId, Date contractStartDate, Date contrachEndDate, Double contractDeposit,
                       Double contractTotalMoney, Employee employeeId, Customer customerId, Service serviceId) {
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

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
            ContractDto contractDto = (ContractDto) target;
        long getDiff = contractDto.contrachEndDate.getTime() - contractDto.contractStartDate.getTime();
        long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
        if (getDaysDiff <= 0 ){
            errors.rejectValue("contrachEndDate", "contrachEndDate.wrongAge", "The next day is smaller than the day before");
            System.out.println(getDaysDiff);
        }







            if (contractDto.getContractDeposit() != null){
                if (contractDto.getContractDeposit() <=0){
                    errors.rejectValue("contractDeposit", "contractDeposit", "Contract Deposit more than 0");
                }
            }else {
                errors.rejectValue("contractDeposit", "contractDeposit", "Contract Deposit Not Null");

            }

        if (contractDto.getContractTotalMoney() != null){
            if (contractDto.getContractTotalMoney() <=0){
                errors.rejectValue("contractTotalMoney", "contractTotalMoney", "Contract Total Money more than 0");
            }
        }else {
            errors.rejectValue("contractTotalMoney", "contractTotalMoney", "Contract Total Money Not Null");

        }

        }


}
