package introduction_to_java.pratice.th_3;

import java.util.Scanner;

public class AreaRectangle {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input width of rectangle");
        width = scanner.nextFloat();
        System.out.println("Please input height of rectangle");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Area of Rectangle: " + area);
    }
}
