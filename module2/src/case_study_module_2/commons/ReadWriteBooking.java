package case_study_module_2.commons;

import case_study_module_2.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBooking {
    private String BOOKING_PATH = "src/case_study_module_2/data/Booking.csv";

    public void writeBooking(Customer customerNew) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(BOOKING_PATH), true));
            bw.write(customerNew.getNameCustomer() + "," + customerNew.getBirthday() + "," + customerNew.getGender() + "," +
                    customerNew.getCmnd() + "," + customerNew.getPhoneNumber() + "," + customerNew.getEmail() + "," +
                    customerNew.getCustomerType() + "," + customerNew.getAddress() +","+ customerNew.getUseService());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
