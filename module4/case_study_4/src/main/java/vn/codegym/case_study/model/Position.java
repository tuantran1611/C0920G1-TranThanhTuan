package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String positionId;
    private String positionName;

    @OneToMany(mappedBy = "positionId")
    private Set<Employee> employees;

    public Position(String positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public Position() {
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
