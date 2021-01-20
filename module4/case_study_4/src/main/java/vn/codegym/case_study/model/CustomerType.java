package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_type_id")
    private String customerTypeId;

    @Column(name = "customer_type_name")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    Set<Customer> customers;

    public CustomerType(String customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public CustomerType() {
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
