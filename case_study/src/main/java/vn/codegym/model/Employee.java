package vn.codegym.model;


import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private Date employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAdress;

    @Column(columnDefinition = "integer default 1")
    private Integer flagDeleteEmployee ;

    @ManyToOne
    @JoinColumn(name = "positionId" , referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegreeID" , referencedColumnName = "educationDegreeID")
    private  EducationDegree educationDegree;


    @ManyToOne
    @JoinColumn(name = "divisionId" ,referencedColumnName =  "divisionId")
    private Division division;


    @OneToMany(mappedBy = "employeeId")
    private List<Contract> contract;


    @OneToOne(mappedBy = "employee")
    private User user;


    public Employee() {
    }


    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
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

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFlagDeleteEmployee() {
        return flagDeleteEmployee;
    }

    public void setFlagDeleteEmployee(Integer flagDeleteEmployee) {
        this.flagDeleteEmployee = flagDeleteEmployee;
    }
}
