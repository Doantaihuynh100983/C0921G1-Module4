package vn.codegym.dto;

public class EmployeeDto {
    private Integer employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAdress;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                       Double employeeSalary, String employeePhone, String employeeEmail, String employeeAdress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAdress = employeeAdress;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAdress() {
        return employeeAdress;
    }

    public void setEmployeeAdress(String employeeAdress) {
        this.employeeAdress = employeeAdress;
    }
}
