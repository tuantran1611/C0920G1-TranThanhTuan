package _1_introduction_to_java.pratice.th_4;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        System.out.println("a :");
        a = sc.nextDouble();
        System.out.println("b :");
        b = sc.nextDouble();
        System.out.println("c :");
        c = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm: ");
                } else {
                    System.out.println("Phương trình vô nghiệm: ");
                }
            }
        } else {
            double x = (c - b) / a;
            System.out.println("Phương trình có 1 nghiệm: " + x);
        }
    }
}
