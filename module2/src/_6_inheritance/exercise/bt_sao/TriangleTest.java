package _6_inheritance.exercise.bt_sao;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập màu sắc muốn vẽ");
        String color = sc.nextLine();
        System.out.println("Bạn muốn tô màu không: true of false");
        boolean fill = sc.nextBoolean();
        System.out.println("Nhập cạnh thứ nhất của tam giác");
        int side1 = sc.nextInt();
        System.out.println("Nhập cạnh thứ hai của tam giác");
        int side2 = sc.nextInt();
        System.out.println("Nhập cạnh thứ ba của tam giác");
        int side3 = sc.nextInt();
        Triangle triangle = new Triangle(color, fill, side1, side2, side3);
        System.out.println(triangle);
    }
}
