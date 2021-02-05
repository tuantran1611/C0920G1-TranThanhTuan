//package vn.codegym.model;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import java.util.Date;
//
//@Entity(name = "contract")
//public class Contract implements Validator {
//    @Id
//    @GeneratedValue(generator = "my_generator")
//    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.common.MyGeneratorContract")
//    private String idContract;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Customer customer;
//
//    @NotNull(message = "Please choose day")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date startDay;
//
//    @NotNull(message = "Please choose day")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date endDay;
//
//    public Contract() {
//    }
//
//    public String getIdContract() {
//        return idContract;
//    }
//
//    public void setIdContract(String idContract) {
//        this.idContract = idContract;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Date getStartDay() {
//        return startDay;
//    }
//
//    public void setStartDay(Date startDay) {
//        this.startDay = startDay;
//    }
//
//    public Date getEndDay() {
//        return endDay;
//    }
//
//    public void setEndDay(Date endDay) {
//        this.endDay = endDay;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Contract.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Contract contract =(Contract) target;
//        if(contract.getStartDay() != null && contract.getEndDay() != null){
//            if (contract.getEndDay().before(contract.getStartDay())) {
//                errors.rejectValue("endDay","endDay.contract");
//            }
//        }
//    }
//}
