//package vn.codegym.model;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//@Entity(name = "customer")
//public class Customer {
//    @Id
//    @GeneratedValue(generator = "my_generator")
//    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.common.MyGeneratorCustomer")
//    private String id;
//    private String nameCus;
//    private int gender;
//    private Date birthDay;
//
//    @OneToMany(mappedBy = "customer")
//    private Set<Contract> contracts;
//
//    public Customer() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getNameCus() {
//        return nameCus;
//    }
//
//    public void setNameCus(String nameCus) {
//        this.nameCus = nameCus;
//    }
//
//    public int getGender() {
//        return gender;
//    }
//
//    public void setGender(int gender) {
//        this.gender = gender;
//    }
//
//    public Date getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(Date birthDay) {
//        this.birthDay = birthDay;
//    }
//}
