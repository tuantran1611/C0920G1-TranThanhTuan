package vn.codegym.case_study.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.case_study.common.MyGeneratorEmployee")
    private String employeeId;

    @NotEmpty(message = "Please input name")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Name not valid")
    private String employeeName;

    @NotNull(message = "Please choose birthday")
    private Date employeeBirthDay;

    @NotEmpty(message = "Please input id card")
    @Pattern(regexp = "^[0-9]{9}$", message = "Id card must have 9 numbers")
    private String employeeIdCard;

    @NotEmpty(message = "Please input salary")
    @Min(value = 0 , message = "Salary must greater than 0")
    private String employeeSalary;

    @NotEmpty(message = "Please input phone")
    @Pattern(regexp = "^(0|(\\(\\+84\\)))[35789]\\d{8}$", message = "Phone must be like 0XXXXXXXXX or (+84)XXXXXXXXX")
    private String employeePhone;

    @NotEmpty(message = "Please input email")
    @Pattern(regexp = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$", message = "Email must be like abc@gmail.com or abc@yahoo.com.vn")
    private String employeeEmail;

    @NotEmpty(message = "Please input address")
    private String employeeAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id" , referencedColumnName = "positionId")
    private Position positionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegreeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division divisionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "employeeId")
    private Set<Contract> contracts;
    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(Date employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
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

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

}
