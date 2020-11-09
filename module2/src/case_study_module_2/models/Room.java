package case_study_module_2.models;

import java.util.Scanner;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String serviceName, double areaRent, int priceRent, int amountMax, String rentType, String freeService) {
        super(id, serviceName, areaRent, priceRent, amountMax, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void showInfor() {
        System.out.println(super.toString() + "," +
                this.toString());
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
