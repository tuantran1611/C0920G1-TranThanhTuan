package case_study_module_2.commons;

import case_study_module_2.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCustomer {
    private String CUSTOMER_PATH = "src/case_study_module_2/data/Customer.csv";

    public void writeCustomerInfo(Customer customer) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(CUSTOMER_PATH), true));
            bw.write(customer.getNameCustomer() + "," + customer.getBirthday() + "," + customer.getGender() + "," +
                    customer.getCmnd() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," +
                    customer.getCustomerType() + "," + customer.getAddress());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> readCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(CUSTOMER_PATH)));
            String[] strArr;
            String line;
            Customer customer;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                customer = new Customer(strArr[0], strArr[1], strArr[2], strArr[3],
                        strArr[4], strArr[5], strArr[6], strArr[7], strArr[8]);
                customers.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
