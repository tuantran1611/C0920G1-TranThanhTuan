package _3_array_method_in_java.pratice.th_sao_1;

import java.util.Scanner;

public class CountAmountStudentPassExam {
    public static void main(String[] args) {
        int size;
        int[] array;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng");
            size = sc.nextInt();
            if (size>30){
                System.out.println("Kích thước mảng phải nhỏ hơn 30");
            }
        } while (size > 30 || size < 0);
        array = new int[size];
        for (int i = 0; i < array.length;i++){
            System.out.println("Nhập điểm học sinh thứ " + (i+1));
            array[i] = sc.nextInt();
        }
        System.out.println("Danh sách điểm của sinh viên");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (array[i] > 5 && array[i] <= 10){
                count++;
            }
        }
        System.out.println("Số sinh viên thi đỗ là: " + count);
    }
}
