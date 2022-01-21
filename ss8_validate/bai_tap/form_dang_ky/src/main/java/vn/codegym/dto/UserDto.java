package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.codegym.entity.User;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    @NotEmpty
    @Size(min = 5 , max = 45 , message = "Size error")
    private String firstName;

    @NotEmpty
    @Size(min = 5 , max = 45 , message = "Size error")
    private String lastName;



    private String phoneNumber;

    @Min(value = 18,message = "more than 18")
    private int age;


    @Email(message = "Email is not valid", regexp ="^(.+)@(.+)$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
    }
}
