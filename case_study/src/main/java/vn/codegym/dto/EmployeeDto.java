package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Division;
import vn.codegym.model.EducationDegree;
import vn.codegym.model.Position;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^\\d{9,10}$", message = "Format Wrong!!")
    private String employeeIdCard;

    @Positive(message = "Salary Is A Negative Number!!")
    private Double employeeSalary;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^(84+|0)(90|91)[0-9]{7}$", message = "Format Wrong!!")
    private String employeePhone;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$", message ="Format Wrong!!")
    private String employeeEmail;

    @NotEmpty(message ="Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String employeeAdress;


    @NotNull(message = "Mandatory Choose !!")
    private Position position;
    @NotNull(message = "Mandatory Choose !!")
    private EducationDegree educationDegree;
    @NotNull(message = "Mandatory Choose !!")
    private Division division;


    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, String employeeName, Date employeeBirthday,
                       String employeeIdCard, Double employeeSalary, String employeePhone,
                       String employeeEmail, String employeeAdress,
                       Position position, EducationDegree educationDegree, Division division) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAdress = employeeAdress;
        this.position = position;
        this.educationDegree = educationDegree;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.employeeBirthday == null) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.wrongBirth", "Birthday must no be blank");
        } else {
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            long millis = System.currentTimeMillis();
            Date curDate = new java.sql.Date(millis);
            int empBirth = Integer.parseInt(formatter.format(employeeDto.employeeBirthday));
            int curentDate = Integer.parseInt(formatter.format(curDate));

            int age = (curentDate - empBirth) / 10000;
            if (age < 18) {
                errors.rejectValue("employeeBirthday", "employeeBirthday.wrongAge", "Employee age must not smaller than 18");
            }
        }
    }
}
