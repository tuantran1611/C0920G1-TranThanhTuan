package case_study_module_2.models;

public class Villa extends Services {
    private String roomStandard;
    private String otherFacilities;
    private String poolArea;
    private String numFloors;
//    private ExtraService extraService;

    public Villa() {
    }

    public Villa(String id, String serviceName, String areaRent, String priceRent, String amountMax, String rentType,
                    String roomStandard, String otherFacilities, String poolArea, String numFloors) {
        super(id, serviceName, areaRent, priceRent, amountMax, rentType);
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.poolArea = poolArea;
        this.numFloors = numFloors;
    }

    public String getRoomStandar() {
        return roomStandard;
    }

    public void setRoomStandar(String roomStandar) {
        this.roomStandard = roomStandar;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(String numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public void showInfor() {
        System.out.println(super.toString() + "," +
        this.toString());
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", roomStandard = " + roomStandard +
                ", otherFacilities = " + otherFacilities +
                ", poolArea = " + poolArea +
                ", numFloors = " + numFloors +
                "}";
    }
}
