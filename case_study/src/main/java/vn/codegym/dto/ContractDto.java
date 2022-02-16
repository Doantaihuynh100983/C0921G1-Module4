package vn.codegym.dto;

public class ContractDto {
    private int contractId;
    private String contractStartDate;
    private String contrachEndDate;
    private double contractDeposit;
    private double contractTotalMoney;

    public ContractDto() {
    }

    public ContractDto(int contractId, String contractStartDate,
                       String contrachEndDate, double contractDeposit, double contractTotalMoney) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contrachEndDate = contrachEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
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
