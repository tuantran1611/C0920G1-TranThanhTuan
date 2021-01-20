package vn.codegym.case_study.model;

public class Service {
    private String serviceId;
    private String serviceName;
    private String serviceArea;
    private String serviceTypeCost;
    private String serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionConvenience;
    private String poolArea;
    private String numberFloor;

    public Service(String serviceName, String serviceArea, String serviceTypeCost, String serviceMaxPeople, RentType rentType,
                   ServiceType serviceType, String standardRoom, String descriptionConvenience, String poolArea, String numberFloor) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceTypeCost = serviceTypeCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Service(String serviceId, String serviceName, String serviceArea, String serviceTypeCost, String serviceMaxPeople,
                   RentType rentType, ServiceType serviceType, String standardRoom, String descriptionConvenience,
                   String poolArea, String numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceTypeCost = serviceTypeCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
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
}
