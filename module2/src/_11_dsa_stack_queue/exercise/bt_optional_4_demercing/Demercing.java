package _11_dsa_stack_queue.exercise.bt_optional_4_demercing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demercing extends Employee {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<>();
    Queue<Employee> nu = new LinkedList<>();
    Queue<Employee> nam = new LinkedList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public void addEmployee() throws ParseException {
        System.out.println("Nhập thông tin nhân viên: ");
        System.out.println("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = sc.nextLine();
        System.out.println("Nhập ngày tháng năm sinh: ");
        Date birthday = sdf.parse(sc.nextLine());
        Employee employee = new Employee(name, gender, birthday);
        employees.add(employee);
        System.out.println(employees);
    }

//    public void outPutFemale(){
//
//    }


}
