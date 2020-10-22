package _3_array_method_in_java.exercise.bt_sao_3;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        System.out.println("Nhập chuỗi: ");
        a = sc.nextLine();
        System.out.println("Nhập ký tự muốn kiểm tra");
        String b = sc.nextLine();

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (b.equals(String.valueOf(a.charAt(i)))) {
                count++;
            }
            System.out.print(a.charAt(i));
        }
        System.out.println("Số ký tự " + b + " trong chuỗi là: " + count);
    }
}
