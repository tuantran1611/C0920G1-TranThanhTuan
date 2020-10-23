package _4_class_and_object_in_java.exercise.bt_1;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào giá trị a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào giá trị b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhập vào giá trị c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Giá trị nhập vào là: " + quadraticEquation.getA() +" "+quadraticEquation.getB()+" "+quadraticEquation.getC());
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Phương trình có 2 nghiệm: ");
            System.out.println("Nghiệm thứ 1: " + quadraticEquation.getRoot1() + " và nghiệm thứ 2: " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Phương trình có 1 nghiệm là: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }

    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt((this.b * this.b - 4 * this.a * this.c))) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt((this.b * this.b - 4 * this.a * this.c))) / (2 * this.a);
    }

}
