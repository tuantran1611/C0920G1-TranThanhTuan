package _6_inheritance.pratice.th_1;

public class TestCircle {
    public static void main(String[] args) {
        Shape.Circle circle = new Shape.Circle();
        System.out.println(circle);

        circle = new Shape.Circle(3.5);
        System.out.println(circle);

        circle = new Shape.Circle("indigo",false,3.5);
        System.out.println(circle);
    }
}
