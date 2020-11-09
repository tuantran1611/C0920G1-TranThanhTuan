package case_study_module_2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Villa extends Services {
    private String roomStandard;
    private String otherFacilities;
    private double poolArea;
    private int numFloors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double areaRent, int priceRent, int amountMax, String rentType, String roomStandard, String otherFacilities, double poolArea, int numFloors) {
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
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
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", poolArea=" + poolArea +
                ", numFloors=" + numFloors +
                '}';
    }
}
