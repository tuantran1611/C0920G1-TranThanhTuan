package case_study_module_2.models;

import java.util.Scanner;

public class House extends Services {
    private String roomStandard;
    private String otherFacilities;
    private int numFloors;

    public House() {
    }

    public House(String roomStandard, String otherFacilities, int numFloors) {
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.numFloors = numFloors;
    }

    public House(String id, String serviceName, double areaRent, int priceRent, int amountMax, String rentType, String roomStandard, String otherFacilities, int numFloors) {
        super(id, serviceName, areaRent, priceRent, amountMax, rentType);
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.numFloors = numFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public void showInfor() {
        System.out.println(super.toString() + "," +
                this.toString());
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", numFloors=" + numFloors +
                '}';
    }
}
