package case_study_module_2.commons;

import case_study_module_2.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBooking {
    private static String BOOKING_PATH = "src/case_study_module_2/data/Booking.csv";

    public static void writeBookingVilla(Customer customerNew) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(BOOKING_PATH), true));
            bw.write(customerNew.getIdCus()+","+customerNew.getNameCustomer() + "," + customerNew.getBirthday()
                    + "," + customerNew.getGender() + "," + customerNew.getCmnd() + "," + customerNew.getPhoneNumber()
                    + "," + customerNew.getEmail() + "," + customerNew.getCustomerType() + "," + customerNew.getAddress()
                    +","+ customerNew.getUseService().getId() +","+ customerNew.getUseService().getServiceName()
                    +","+ customerNew.getUseService().getAreaRent()+","+customerNew.getUseService().getPriceRent()
                    +","+ customerNew.getUseService().getAmountMax()+","+customerNew.getUseService().getRentType()
                    +","+ ((Villa) (customerNew.getUseService())).getRoomStandar()
                    +","+ ((Villa) (customerNew.getUseService())).getOtherFacilities()
                    +","+ ((Villa) (customerNew.getUseService())).getPoolArea()
                    +","+ ((Villa) (customerNew.getUseService())).getNumFloors()
            );
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBookingHouse(Customer customerNew) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(BOOKING_PATH), true));
            bw.write(customerNew.getIdCus()+","+customerNew.getNameCustomer() + "," + customerNew.getBirthday()
                    + "," + customerNew.getGender() + "," + customerNew.getCmnd() + "," + customerNew.getPhoneNumber()
                    + "," + customerNew.getEmail() + "," + customerNew.getCustomerType() + "," + customerNew.getAddress()
                    +","+ customerNew.getUseService().getId() +","+ customerNew.getUseService().getServiceName()
                    +","+ customerNew.getUseService().getAreaRent()+","+customerNew.getUseService().getPriceRent()
                    +","+ customerNew.getUseService().getAmountMax()+","+customerNew.getUseService().getRentType()
                    +","+ ((House) (customerNew.getUseService())).getRoomStandard()
                    +","+ ((House) (customerNew.getUseService())).getOtherFacilities()
                    +","+ ((House) (customerNew.getUseService())).getNumFloors()
            );
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readBookingVilla(){
        List<Customer> customers = new ArrayList<>();
        Villa villa;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(BOOKING_PATH)));
            String[] strArr;
            String line;
            Customer customer;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                villa = new Villa(strArr[9],strArr[10],strArr[11],strArr[12],strArr[13],strArr[14],strArr[15],
                        strArr[16],strArr[17],strArr[18]);

                customer = new Customer(strArr[0], strArr[1], strArr[2], strArr[3],
                        strArr[4], strArr[5], strArr[6], strArr[7], strArr[8],villa);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public static void writeBookingRoom(Customer customerNew) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(BOOKING_PATH), true));
            bw.write(customerNew.getIdCus()+","+customerNew.getNameCustomer() + "," + customerNew.getBirthday()
                    + "," + customerNew.getGender() + "," + customerNew.getCmnd() + "," + customerNew.getPhoneNumber()
                    + "," + customerNew.getEmail() + "," + customerNew.getCustomerType() + "," + customerNew.getAddress()
                    +","+ customerNew.getUseService().getId() +","+ customerNew.getUseService().getServiceName()
                    +","+ customerNew.getUseService().getAreaRent()+","+customerNew.getUseService().getPriceRent()
                    +","+ customerNew.getUseService().getAmountMax()+","+customerNew.getUseService().getRentType()
                    +","+ ((Room) (customerNew.getUseService())).getFreeService()
            );
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
