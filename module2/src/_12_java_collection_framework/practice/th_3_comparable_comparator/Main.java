package _12_java_collection_framework.practice.th_3_comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Collections.sort(studentList);
        for (Student st : studentList){
            System.out.println(st.toString());
        }
        System.out.println("Comparator");
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(studentList,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for (Student st : studentList){
            System.out.println(st.toString());
        }
    }
}
