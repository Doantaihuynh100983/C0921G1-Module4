package vn.codegym.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotBlank(message = "Không được để trống !!")
    @Size(min = 2,max = 20 ,message = "Vượt Quá Độ Dài Cho Phép !!")
    private String name;

    @Min(value = 10 , message = "Tuổi Phải Lớn Hơn 10")
    @NotNull
    private int age;

    public UserDto(@NotEmpty(message = "Không được để trống !!") @Size(min = 2, max = 20, message = "Vượt Quá Độ Dài Cho Phép !!")
                           String name, @Min(value = 10, message = "Tuổi Phải Lớn Hơn 10") int age) {
        this.name = name;
        this.age = age;
    }

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
