package _4_class_and_object_in_java.pratice.th_1;

import java.util.Scanner;

public class Ex14_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        double width = scanner.nextDouble();
        System.out.println("Enter height");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your rectangle: " + rectangle.display());
        System.out.println("Perimeter of rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of rectangle: " + rectangle.getArea());
    }
}
