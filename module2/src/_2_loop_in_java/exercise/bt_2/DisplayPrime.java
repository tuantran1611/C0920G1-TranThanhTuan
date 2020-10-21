package _2_loop_in_java.exercise.bt_2;

import java.util.Scanner;

public class DisplayPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int count = 0;
        int n = 2;
        boolean check = false;
        do {
            System.out.println("Nhập số lượng số nguyên tố muốn hiển thị");
            num = sc.nextInt();
        } while (num < 0);
        while (count < num) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(n);
                count++;
            }
            check = false;
            n++;
        }
    }
}
