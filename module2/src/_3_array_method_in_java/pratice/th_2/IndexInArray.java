package _3_array_method_in_java.pratice.th_2;

import java.util.Scanner;

public class IndexInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên bạn muốn tìm");
        String input_name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Vị trí tên của học sinh " + input_name + " ở vị trí " + (i + 1) + ".");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy " + input_name + " trong danh sách.");
        }
    }
}
