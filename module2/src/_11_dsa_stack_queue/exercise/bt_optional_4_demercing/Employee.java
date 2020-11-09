package _11_dsa_stack_queue.exercise.bt_optional_4_demercing;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String name;
    private String gender;
    private Date birthday;

    public Employee() {
    }

    public Employee(String name, String gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Employee o1) {
        return this.getBirthday().compareTo(o1.getBirthday());
    }
}
