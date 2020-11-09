package case_study_module_2.models;

public abstract class Services {
    private String id;
    private String serviceName;
    private double areaRent;
    private int priceRent;
    private int amountMax;
    private String rentType;

    public Services() {
    }

    public Services(String id, String serviceName, double areaRent, int priceRent, int amountMax, String rentType) {
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

    public double getAreaRent() {
        return areaRent;
    }

    public void setAreaRent(double areaRent) {
        this.areaRent = areaRent;
    }

    public int getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(int priceRent) {
        this.priceRent = priceRent;
    }

    public int getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(int amountMax) {
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
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaRent=" + areaRent +
                ", priceRent=" + priceRent +
                ", amountMax=" + amountMax +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
