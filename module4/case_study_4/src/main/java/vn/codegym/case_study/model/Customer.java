package vn.codegym.case_study.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.case_study.common.MyGenerator")
    private String customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @NotEmpty(message = "Please input your name!")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Name not valid")
    @Column(name = "customer_name")
    private String customerName;

    @NotEmpty(message = "Please choose your birth day")
    @Column(name = "customer_birthday")
    private Date customerBirthDay;

    @Column(name = "customer_gender")
    private int customerGender;

    @NotEmpty(message = "Please input id card")
    @Pattern(regexp = "^[0-9]{9}$", message = "Id card must have 9 numbers")
    @Column(name = "customer_id_card")
    private String customerIdCard;

    @NotEmpty(message = "Please input phone")
    @Pattern(regexp = "^(0|(\\(\\+84\\)))[35789]\\d{8}$", message = "Phone must be like 0XXXXXXXXX or (+84)XXXXXXXXX")
    @Column(name = "customer_phone")
    private String customerPhone;

    @NotEmpty(message = "Please input email")
    @Pattern(regexp = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$", message = "Email must be like abc@gmail.com or abc@yahoo.com.vn")
    @Column(name = "customer_email")
    private String customerEmail;

    @NotEmpty(message = "Please input address")
    @Column(name = "customer_address")
    private String customerAddress;

    @OneToMany(mappedBy = "customerId")
    private Set<Contract> contracts;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerTypeId() {
        return customerType;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerType = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(Date customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

}
