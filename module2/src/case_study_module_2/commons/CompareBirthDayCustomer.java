package case_study_module_2.commons;

import case_study_module_2.models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareBirthDayCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = f.parse(o1.getBirthday());
            date2 = f.parse(o2.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int compareName = o1.getNameCustomer().compareTo(o2.getNameCustomer());
        if (compareName == 0) {
            return date1.compareTo(date2);
        } else {
            return compareName;
        }
    }
}