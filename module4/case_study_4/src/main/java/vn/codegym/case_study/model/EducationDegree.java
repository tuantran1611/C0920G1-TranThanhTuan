package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegreeId")
    private Set<Employee> employees;

    public EducationDegree(String educationDegreeId, String educationDegreeName) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree() {
    }

    public String getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(String educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
