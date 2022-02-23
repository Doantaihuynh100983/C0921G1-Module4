package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String userName;
    private String passWord;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "use_role",
            joinColumns = @JoinColumn(name = "user_name" ),
            inverseJoinColumns = @JoinColumn(name = "role_id" )
    )
    private List<Role> role;


    @OneToOne
    @JoinColumn(name = "employeeId" , referencedColumnName = "employeeId")
    private Employee employee;






    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public User() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
