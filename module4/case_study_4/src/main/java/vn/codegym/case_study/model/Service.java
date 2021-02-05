package vn.codegym.case_study.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "vn.codegym.case_study.common.MyGeneratorService")
    private String serviceId;

    @NotEmpty(message = "Please input Service Name")
    private String serviceName;

    @NotEmpty(message = "Please input Area")
    @Min(value = 0 , message = "Area must greater than 0")
    private String serviceArea;

    @NotEmpty(message = "Please input Cost")
    @Min(value = 0 , message = "Cost must greater than 0")
    private String serviceTypeCost;

    @NotEmpty(message = "Please input Max people")
    @Min(value = 0 , message = "Amount must greater than 0")
    private String serviceMaxPeople;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    private String standardRoom;
    private String descriptionConvenience;

    @NotEmpty(message = "Please input Pool Area")
    @Min(value = 0 , message = "Pool Area must greater than 0")
    private String poolArea;

    @NotEmpty(message = "Please input Floors")
    @Min(value = 0 , message = "Floors must greater than 0")
    private String numberFloor;

    @OneToMany(mappedBy = "serviceId")
    private Set<Contract> contractSet;

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceTypeCost() {
        return serviceTypeCost;
    }

    public void setServiceTypeCost(String serviceTypeCost) {
        this.serviceTypeCost = serviceTypeCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionConvenience() {
        return descriptionConvenience;
    }

    public void setDescriptionConvenience(String descriptionConvenience) {
        this.descriptionConvenience = descriptionConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
