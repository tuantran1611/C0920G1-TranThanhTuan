package case_study_module_2.models;

import case_study_module_2.commons.ReadWriteEmployee;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Cabinet {

    public static void searchProfileEmployee(){
        boolean check = false;
        do {
            System.out.println("Nhập mã số nhân viên: ");
            String idEmployee = new Scanner(System.in).nextLine();
            Stack<Employee> employeeStack = new Stack<>();
            Map<String,Employee> mapEmployee = ReadWriteEmployee.readEmployee();
            for (Map.Entry<String, Employee> entry : mapEmployee.entrySet()) {
                employeeStack.push(entry.getValue());
            }

            for (int i = 0; i < employeeStack.size(); i++){
                if (idEmployee.equals(employeeStack.peek().getIdEmployee())){
                    System.out.println(employeeStack.peek().toString());
                    check = true;
                    break;
                } else {
                    employeeStack.pop();
                }
            }
        } while (!check);
    }
}
