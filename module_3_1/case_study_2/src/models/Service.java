package models;

public class Service {
    private String serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceTypeCost;
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionConvenience;
    private double poolArea;
    private int numberFloor;

    public Service(String serviceName, int serviceArea, double serviceTypeCost, int serviceMaxPeople, RentType rentType,
                   ServiceType serviceType, String standardRoom, String descriptionConvenience, double poolArea, int numberFloor) {
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

    public Service(String serviceId, String serviceName, int serviceArea, double serviceTypeCost, int serviceMaxPeople,
                   RentType rentType, ServiceType serviceType, String standardRoom, String descriptionConvenience,
                   double poolArea, int numberFloor) {
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

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceTypeCost() {
        return serviceTypeCost;
    }

    public void setServiceTypeCost(double serviceTypeCost) {
        this.serviceTypeCost = serviceTypeCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
