package case_study_module_2.services;

import case_study_module_2.commons.ReadWriteEmployee;
import case_study_module_2.models.Employee;

import java.util.Map;

public class ShowInfoEmployee {
    public static void showInfoEmployee(){
        Map<String, Employee> mapEmployee = ReadWriteEmployee.readEmployee();
        for (Map.Entry<String, Employee> entry : mapEmployee.entrySet()) {
            System.out.println("Mã số: " + entry.getKey() + " , " + entry.getValue());
        }
    }
}
