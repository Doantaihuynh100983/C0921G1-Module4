package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDto implements Validator {

    private Integer customerId;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String customerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;

    @NotNull(message = "Mandatory Choose !!")
    private Boolean customerGender;


    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^\\d{9,10}$", message = "Format Wrong!!")
    private String customerIdCard;

    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^(84+|0)(90|91)[0-9]{7}$", message = "Format Wrong!!")
    private String customerPhone;


    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$", message = "Format Wrong!!")
    private String customerEmail;


    @NotEmpty(message = "Do not use spaces !!!")
    @Pattern(regexp = "^[\\p{Lu}\\p{Ll}\\s0-9]*$", message = "Format Wrong!!")
    private String customerAddress;

    @NotNull(message = "Mandatory Choose !!")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerName, Date customerBirthday, Boolean customerGender,
                       String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDto customerDto = (CustomerDto) target;
        if (customerDto.customerBirthday == null) {
            errors.rejectValue("customerBirthday", "customerBirthday.wrongBirth", "Birthday must no be blank");
        } else {
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            long millis = System.currentTimeMillis();
            Date curDate = new java.sql.Date(millis);
            int empBirth = Integer.parseInt(formatter.format(customerDto.customerBirthday));
            int curentDate = Integer.parseInt(formatter.format(curDate));

            int age = (curentDate - empBirth) / 10000;
            if (age < 18) {
                errors.rejectValue("customerBirthday", "customerBirthday.wrongAge", "Customer age must not smaller than 18");
            }
        }
    }
}
