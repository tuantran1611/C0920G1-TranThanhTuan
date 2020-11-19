package case_study_module_2.models;

public abstract class Services {
    private String id;
    private String serviceName;
    private String areaRent;
    private String priceRent;
    private String amountMax;
    private String rentType;

    public Services() {
    }

    public Services(String id, String serviceName, String areaRent, String priceRent, String amountMax, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaRent = areaRent;
        this.priceRent = priceRent;
        this.amountMax = amountMax;
        this.rentType = rentType;
    }

    public abstract void showInfor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAreaRent() {
        return areaRent;
    }

    public void setAreaRent(String areaRent) {
        this.areaRent = areaRent;
    }

    public String getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(String priceRent) {
        this.priceRent = priceRent;
    }

    public String getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(String amountMax) {
        this.amountMax = amountMax;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", serviceName = " + serviceName +
                ", areaRent= " + areaRent +
                ", priceRent= " + priceRent +
                ", amountMax= " + amountMax +
                ", rentType= " + rentType;
    }
}
