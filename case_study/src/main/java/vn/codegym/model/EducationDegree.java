package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer educationDegreeID;
        private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employee;


    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree() {
    }

    public Integer getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(Integer educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
