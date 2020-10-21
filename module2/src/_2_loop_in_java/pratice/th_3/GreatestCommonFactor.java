package _2_loop_in_java.pratice.th_3;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a");
        a = scanner.nextInt();
        System.out.println("Enter number b");
        b = scanner.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0){
            System.out.println("No greatest common factor");
        }
        while (a != b){
            if (a > b){
                a = a -b;
            } else {
                b = b - a;
            }
        }
        System.out.println("Greatest common factor: "  + a);
    }
}
