package vn.codegym.case_study.model;

public class RentType {
    private String rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    public RentType() {
    }

    public RentType(String rentTypeId, String rentTypeName, double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
