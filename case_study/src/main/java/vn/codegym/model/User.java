package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String userName;
    private String passWord;

    @OneToMany(mappedBy = "user")
    private List<Employee> employees;


}
