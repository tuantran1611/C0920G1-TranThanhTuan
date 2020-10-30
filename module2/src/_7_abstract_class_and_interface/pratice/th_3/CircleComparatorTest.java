package _7_abstract_class_and_interface.pratice.th_3;

import _6_inheritance.pratice.th_1.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle("indigo", false, 3.5);

        System.out.println("Pre-sort");
        for (Circle circle : circles){
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted: ");
        for (Circle circle : circles){
            System.out.println(circle);
        }
    }
}
