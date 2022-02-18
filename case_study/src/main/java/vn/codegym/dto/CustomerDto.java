package vn.codegym.dto;

import vn.codegym.model.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDto {

    private Integer customerId;

//    @NotEmpty(message = "Không dùng dấu cách nhé !!!")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Định Dạng Sai !!")
    private String customerName;

    private String customerBirthday;

    private Boolean customerGender;


//    @NotEmpty(message = "Không dùng dấu cách nhé !!!")
//    @Pattern(regexp = "^\\d{12}|\\d{9}$", message = "Định Dạng Sai !!")
    private String customerIdCard;


    private String customerPhone;


//    @NotEmpty(message = "Không dùng dấu cách nhé !!!")
//    @Pattern(regexp = "^\\w+@\\w+[.]\\w+$", message = "Định Dạng Sai !!")
    private String customerEmail;



    private String customerAddress;
    //adrees với phone chưa validate
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerName, String customerBirthday, Boolean customerGender,
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

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
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
}
